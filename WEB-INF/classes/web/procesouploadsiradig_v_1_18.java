package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class procesouploadsiradig_v_1_18 extends GXProcedure
{
   public procesouploadsiradig_v_1_18( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( procesouploadsiradig_v_1_18.class ), "" );
   }

   public procesouploadsiradig_v_1_18( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 ,
                            java.util.Date aP3 ,
                            GXSimpleCollection<String>[] aP4 )
   {
      procesouploadsiradig_v_1_18.this.aP5 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        GXSimpleCollection<String>[] aP4 ,
                        short[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             GXSimpleCollection<String>[] aP4 ,
                             short[] aP5 )
   {
      procesouploadsiradig_v_1_18.this.AV17CliCod = aP0;
      procesouploadsiradig_v_1_18.this.AV26EmpCod = aP1;
      procesouploadsiradig_v_1_18.this.AV46ParmLegNumero = aP2;
      procesouploadsiradig_v_1_18.this.AV16ArchSiradigFec = aP3;
      procesouploadsiradig_v_1_18.this.aP4 = aP4;
      procesouploadsiradig_v_1_18.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, "1") ;
      AV53vez = (short)(1) ;
      AV48seguir = true ;
      while ( ( AV53vez <= 2 ) && ( AV48seguir ) )
      {
         AV27errores.clear();
         AV12ahora = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( " &vez ", "")+GXutil.trim( GXutil.str( AV53vez, 4, 0))) ;
         /* Using cursor P011W2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV17CliCod), Short.valueOf(AV26EmpCod), AV16ArchSiradigFec});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A85ArchSiradigFec = P011W2_A85ArchSiradigFec[0] ;
            A1EmpCod = P011W2_A1EmpCod[0] ;
            A3CliCod = P011W2_A3CliCod[0] ;
            A562ArchSiradigFile = P011W2_A562ArchSiradigFile[0] ;
            A565ArchSiradigEstado = P011W2_A565ArchSiradigEstado[0] ;
            A566ArchSiradigError = P011W2_A566ArchSiradigError[0] ;
            A563ArchSiradigType = P011W2_A563ArchSiradigType[0] ;
            A564ArchSiradigName = P011W2_A564ArchSiradigName[0] ;
            A567ArchSirdigNameAndType = GXutil.trim( A564ArchSiradigName) + " ." + GXutil.trim( A563ArchSiradigType) ;
            AV9ArchSiradigFile = A562ArchSiradigFile ;
            AV31File.setSource( A562ArchSiradigFile );
            new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "archivo entra ", "")) ;
            if ( AV31File.exists() )
            {
               AV55XML = AV31File.readAllText("") ;
               AV47presentacion.fromxml(AV55XML, null, null);
               new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "&presentacion to xml ", "")+AV47presentacion.toxml(false, true, "presentacion", "")) ;
               if ( (0==AV47presentacion.getgxTv_Sdtpresentacion_1_18_Periodo()) )
               {
                  AV27errores.add(httpContext.getMessage( "Archivo vacío o con formato inválido", ""), 0);
                  A565ArchSiradigEstado = (short)(4) ;
                  A566ArchSiradigError = GXutil.trim( (String)AV27errores.elementAt(-1+1)) ;
               }
               else
               {
                  AV8anio = AV47presentacion.getgxTv_Sdtpresentacion_1_18_Periodo() ;
                  AV10LegCUIL = AV47presentacion.getgxTv_Sdtpresentacion_1_18_Empleado().getgxTv_Sdtpresentacion_1_18_empleado_Cuit() ;
                  GXv_int1[0] = AV11LegNumero ;
                  new web.obtenerlegajoporcuit(remoteHandle, context).execute( AV17CliCod, AV26EmpCod, AV10LegCUIL, GXv_int1) ;
                  procesouploadsiradig_v_1_18.this.AV11LegNumero = GXv_int1[0] ;
                  AV57legnumeros.add((int)(AV11LegNumero), 0);
                  if ( (0==AV11LegNumero) )
                  {
                     AV27errores.add(httpContext.getMessage( "No existe legajo con CUIL ", "")+GXutil.trim( GXutil.str( AV10LegCUIL, 11, 0)), 0);
                  }
                  else
                  {
                     if ( ! (0==AV46ParmLegNumero) && ( AV46ParmLegNumero != AV11LegNumero ) )
                     {
                        AV27errores.add(httpContext.getMessage( "No coincide Legajo con empleado del archivo", ""), 0);
                     }
                     else
                     {
                        new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, "2") ;
                        AV32i = (short)(1) ;
                        while ( AV32i <= AV47presentacion.getgxTv_Sdtpresentacion_1_18_Deducciones().size() )
                        {
                           GXv_char2[0] = AV35LegDedConCodigo ;
                           new web.getsiradigconcodigo(remoteHandle, context).execute( AV17CliCod, "DED", GXutil.trim( ((web.Sdtpresentacion_1_18_deduccion)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Deducciones().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_deduccion_Tipo()), GXv_char2) ;
                           procesouploadsiradig_v_1_18.this.AV35LegDedConCodigo = GXv_char2[0] ;
                           AV34LegDedCodSiradig = (byte)(GXutil.lval( ((web.Sdtpresentacion_1_18_deduccion)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Deducciones().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_deduccion_Tipo())) ;
                           GXv_char2[0] = AV36LegDedConDescrip ;
                           GXv_boolean3[0] = AV28existeConcepto ;
                           new web.conceptogetdescri2(remoteHandle, context).execute( AV17CliCod, AV35LegDedConCodigo, GXv_char2, GXv_boolean3) ;
                           procesouploadsiradig_v_1_18.this.AV36LegDedConDescrip = GXv_char2[0] ;
                           procesouploadsiradig_v_1_18.this.AV28existeConcepto = GXv_boolean3[0] ;
                           if ( ! AV28existeConcepto )
                           {
                              if ( (GXutil.strcmp("", AV35LegDedConCodigo)==0) )
                              {
                                 if ( (0==AV34LegDedCodSiradig) )
                                 {
                                    AV27errores.add(httpContext.getMessage( "No se pudo recuperar código de deducción", ""), 0);
                                 }
                                 else
                                 {
                                    AV27errores.add(httpContext.getMessage( "No se pudo recuperar concepto con código ", "")+GXutil.trim( GXutil.str( AV34LegDedCodSiradig, 2, 0)), 0);
                                 }
                              }
                              else
                              {
                                 AV27errores.add(httpContext.getMessage( "No existe concepto ", "")+GXutil.trim( AV35LegDedConCodigo), 0);
                              }
                           }
                           else
                           {
                              if ( AV53vez == 2 )
                              {
                                 AV37LegDedDescrip = GXutil.trim( ((web.Sdtpresentacion_1_18_deduccion)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Deducciones().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_deduccion_Descbasica()) ;
                                 if ( ! (GXutil.strcmp("", ((web.Sdtpresentacion_1_18_deduccion)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Deducciones().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_deduccion_Descadicional())==0) )
                                 {
                                    AV37LegDedDescrip += ". " + GXutil.trim( ((web.Sdtpresentacion_1_18_deduccion)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Deducciones().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_deduccion_Descadicional()) ;
                                 }
                                 if ( ((web.Sdtpresentacion_1_18_deduccion)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Deducciones().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_deduccion_Periodos().size() > 0 )
                                 {
                                    AV45p = (short)(1) ;
                                    while ( AV45p <= ((web.Sdtpresentacion_1_18_deduccion)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Deducciones().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_deduccion_Periodos().size() )
                                    {
                                       AV41mesDesde = ((web.Sdtpresentacion_1_18_deduccion_periodo)((web.Sdtpresentacion_1_18_deduccion)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Deducciones().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_deduccion_Periodos().elementAt(-1+AV45p)).getgxTv_Sdtpresentacion_1_18_deduccion_periodo_Mesdesde() ;
                                       AV43mesHasta = ((web.Sdtpresentacion_1_18_deduccion_periodo)((web.Sdtpresentacion_1_18_deduccion)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Deducciones().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_deduccion_Periodos().elementAt(-1+AV45p)).getgxTv_Sdtpresentacion_1_18_deduccion_periodo_Meshasta() ;
                                       AV40LegDedImporte = ((web.Sdtpresentacion_1_18_deduccion_periodo)((web.Sdtpresentacion_1_18_deduccion)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Deducciones().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_deduccion_Periodos().elementAt(-1+AV45p)).getgxTv_Sdtpresentacion_1_18_deduccion_periodo_Montomensual() ;
                                       while ( AV41mesDesde <= AV43mesHasta )
                                       {
                                          AV38LegDedFchDes = localUtil.ymdtod( AV8anio, AV41mesDesde, 1) ;
                                          AV39LegDedFchHas = GXutil.eomdate( AV38LegDedFchDes) ;
                                          new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "DEDUCCION  ", "")+GXutil.trim( AV37LegDedDescrip)+httpContext.getMessage( " &LegDedConCodigo ", "")+GXutil.trim( AV35LegDedConCodigo)) ;
                                          AV58fechas.add(AV38LegDedFchDes, 0);
                                          GXv_boolean3[0] = AV23dioAlta ;
                                          new web.grabalegajodeduccion(remoteHandle, context).execute( AV17CliCod, AV26EmpCod, AV11LegNumero, AV35LegDedConCodigo, AV38LegDedFchDes, AV39LegDedFchHas, AV37LegDedDescrip, AV40LegDedImporte, AV34LegDedCodSiradig, "", GXv_boolean3) ;
                                          procesouploadsiradig_v_1_18.this.AV23dioAlta = GXv_boolean3[0] ;
                                          AV13altas = (short)(AV13altas+1) ;
                                          AV41mesDesde = (short)(AV41mesDesde+1) ;
                                       }
                                       AV45p = (short)(AV45p+1) ;
                                    }
                                 }
                                 else
                                 {
                                    AV38LegDedFchDes = localUtil.ymdtod( AV8anio, 1, 1) ;
                                    AV42MesFechaAporte = (short)(1) ;
                                    AV33LegDedCodMot = "" ;
                                    AV65numeroDocFamiliar = "" ;
                                    AV60apellido = "" ;
                                    AV62parentesco = (short)(0) ;
                                    AV63nacFecha = GXutil.nullDate() ;
                                    AV29FamTomaDeducImpGan = DecimalUtil.ZERO ;
                                    AV71GXV2 = 1 ;
                                    AV70GXV1 = ((web.Sdtpresentacion_1_18_deduccion)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Deducciones().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_deduccion_Detalles() ;
                                    while ( AV71GXV2 <= AV70GXV1.size() )
                                    {
                                       AV21detalle = (web.Sdtpresentacion_1_18_deduccion_detalle)((web.Sdtpresentacion_1_18_deduccion_detalle)AV70GXV1.elementAt(-1+AV71GXV2));
                                       if ( ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV21detalle.getgxTv_Sdtpresentacion_1_18_deduccion_detalle_Nombre())), httpContext.getMessage( "FECHAAPORTE", "")) == 0 ) || ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV21detalle.getgxTv_Sdtpresentacion_1_18_deduccion_detalle_Nombre())), httpContext.getMessage( "FECHAADQUISICION", "")) == 0 ) )
                                       {
                                          AV51valorSplit = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV21detalle.getgxTv_Sdtpresentacion_1_18_deduccion_detalle_Valor(),"-")) ;
                                          if ( AV51valorSplit.size() >= 2 )
                                          {
                                             AV42MesFechaAporte = (short)(GXutil.lval( (String)AV51valorSplit.elementAt(-1+2))) ;
                                          }
                                          AV38LegDedFchDes = localUtil.ymdtod( AV8anio, AV42MesFechaAporte, 1) ;
                                          if (true) break;
                                       }
                                       else if ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV21detalle.getgxTv_Sdtpresentacion_1_18_deduccion_detalle_Nombre())), httpContext.getMessage( "MES", "")) == 0 )
                                       {
                                          AV38LegDedFchDes = localUtil.ymdtod( AV8anio, (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV21detalle.getgxTv_Sdtpresentacion_1_18_deduccion_detalle_Valor(), "."))), 1) ;
                                       }
                                       else if ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV21detalle.getgxTv_Sdtpresentacion_1_18_deduccion_detalle_Nombre())), httpContext.getMessage( "MOTIVO", "")) == 0 )
                                       {
                                          AV33LegDedCodMot = GXutil.trim( AV21detalle.getgxTv_Sdtpresentacion_1_18_deduccion_detalle_Valor()) ;
                                       }
                                       if ( GXutil.strcmp(((web.Sdtpresentacion_1_18_deduccion)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Deducciones().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_deduccion_Tipo(), "32") == 0 )
                                       {
                                          AV59porcentajeDeduccion = 0 ;
                                          if ( GXutil.strcmp(AV21detalle.getgxTv_Sdtpresentacion_1_18_deduccion_detalle_Nombre(), httpContext.getMessage( "parentescoFamiliar", "")) == 0 )
                                          {
                                             AV62parentesco = (short)(GXutil.lval( AV21detalle.getgxTv_Sdtpresentacion_1_18_deduccion_detalle_Valor())) ;
                                          }
                                          if ( GXutil.strcmp(AV21detalle.getgxTv_Sdtpresentacion_1_18_deduccion_detalle_Nombre(), httpContext.getMessage( "porcentajeDedFamiliar", "")) == 0 )
                                          {
                                             AV59porcentajeDeduccion = (int)(GXutil.lval( AV21detalle.getgxTv_Sdtpresentacion_1_18_deduccion_detalle_Valor())) ;
                                          }
                                          if ( GXutil.strcmp(AV21detalle.getgxTv_Sdtpresentacion_1_18_deduccion_detalle_Nombre(), httpContext.getMessage( "apellidoNombreFamiliar", "")) == 0 )
                                          {
                                             AV64palabras = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV21detalle.getgxTv_Sdtpresentacion_1_18_deduccion_detalle_Valor()," ")) ;
                                             if ( AV64palabras.size() > 0 )
                                             {
                                                AV60apellido = GXutil.trim( (String)AV64palabras.elementAt(-1+1)) ;
                                                if ( AV64palabras.size() > 1 )
                                                {
                                                   AV61nombre = GXutil.trim( (String)AV64palabras.elementAt(-1+2)) ;
                                                }
                                             }
                                          }
                                          if ( GXutil.strcmp(AV21detalle.getgxTv_Sdtpresentacion_1_18_deduccion_detalle_Nombre(), httpContext.getMessage( "numeroDocFamiliar", "")) == 0 )
                                          {
                                             AV65numeroDocFamiliar = GXutil.trim( AV21detalle.getgxTv_Sdtpresentacion_1_18_deduccion_detalle_Valor()) ;
                                          }
                                          AV63nacFecha = GXutil.serverDate( context, remoteHandle, pr_default) ;
                                          AV63nacFecha = GXutil.addyr( AV63nacFecha, (short)(-19)) ;
                                       }
                                       AV71GXV2 = (int)(AV71GXV2+1) ;
                                    }
                                    AV39LegDedFchHas = AV38LegDedFchDes ;
                                    AV40LegDedImporte = ((web.Sdtpresentacion_1_18_deduccion)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Deducciones().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_deduccion_Montototal() ;
                                    new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "DEDUCCION SIN PERIODO ", "")+GXutil.trim( AV37LegDedDescrip)+httpContext.getMessage( " &LegDedConCodigo ", "")+GXutil.trim( AV35LegDedConCodigo)) ;
                                    AV58fechas.add(AV38LegDedFchDes, 0);
                                    GXv_boolean3[0] = AV23dioAlta ;
                                    new web.grabalegajodeduccion(remoteHandle, context).execute( AV17CliCod, AV26EmpCod, AV11LegNumero, AV35LegDedConCodigo, AV38LegDedFchDes, AV39LegDedFchHas, AV37LegDedDescrip, AV40LegDedImporte, AV34LegDedCodSiradig, AV33LegDedCodMot, GXv_boolean3) ;
                                    procesouploadsiradig_v_1_18.this.AV23dioAlta = GXv_boolean3[0] ;
                                    AV13altas = (short)(AV13altas+1) ;
                                    if ( GXutil.strcmp(((web.Sdtpresentacion_1_18_deduccion)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Deducciones().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_deduccion_Tipo(), "32") == 0 )
                                    {
                                       AV29FamTomaDeducImpGan = DecimalUtil.doubleToDec(AV59porcentajeDeduccion/ (double) (100)) ;
                                       new web.actualizarfamiliarsiradig(remoteHandle, context).execute( AV17CliCod, AV26EmpCod, AV11LegNumero, AV65numeroDocFamiliar, AV60apellido, AV61nombre, AV62parentesco, AV63nacFecha, AV29FamTomaDeducImpGan, (short)(GXutil.month( AV38LegDedFchDes)), (short)(GXutil.month( AV39LegDedFchHas))) ;
                                    }
                                 }
                              }
                           }
                           AV32i = (short)(AV32i+1) ;
                        }
                        new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, "3") ;
                        AV32i = (short)(1) ;
                        while ( AV32i <= AV47presentacion.getgxTv_Sdtpresentacion_1_18_Retperpagos().size() )
                        {
                           GXt_char4 = AV35LegDedConCodigo ;
                           GXt_char5 = AV35LegDedConCodigo ;
                           GXv_char2[0] = GXt_char5 ;
                           new web.pagosacuenta_codigoparam(remoteHandle, context).execute( GXv_char2) ;
                           procesouploadsiradig_v_1_18.this.GXt_char5 = GXv_char2[0] ;
                           GXv_char6[0] = GXt_char4 ;
                           new web.getparametro(remoteHandle, context).execute( AV17CliCod, GXt_char5, GXv_char6) ;
                           procesouploadsiradig_v_1_18.this.GXt_char4 = GXv_char6[0] ;
                           AV35LegDedConCodigo = GXt_char4 ;
                           AV34LegDedCodSiradig = (byte)(GXutil.lval( ((web.Sdtpresentacion_1_18_retPerPago)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Retperpagos().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_retPerPago_Tipo())) ;
                           GXv_char6[0] = AV36LegDedConDescrip ;
                           GXv_boolean3[0] = AV28existeConcepto ;
                           new web.conceptogetdescri2(remoteHandle, context).execute( AV17CliCod, AV35LegDedConCodigo, GXv_char6, GXv_boolean3) ;
                           procesouploadsiradig_v_1_18.this.AV36LegDedConDescrip = GXv_char6[0] ;
                           procesouploadsiradig_v_1_18.this.AV28existeConcepto = GXv_boolean3[0] ;
                           if ( ! AV28existeConcepto )
                           {
                              AV27errores.add(httpContext.getMessage( "No existe concepto ", "")+GXutil.trim( AV35LegDedConCodigo), 0);
                           }
                           else
                           {
                              if ( AV53vez == 2 )
                              {
                                 AV45p = (short)(1) ;
                                 while ( AV45p <= ((web.Sdtpresentacion_1_18_retPerPago)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Retperpagos().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_retPerPago_Periodos().size() )
                                 {
                                    AV41mesDesde = ((web.Sdtpresentacion_1_18_retPerPago_periodo)((web.Sdtpresentacion_1_18_retPerPago)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Retperpagos().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_retPerPago_Periodos().elementAt(-1+AV45p)).getgxTv_Sdtpresentacion_1_18_retPerPago_periodo_Mesdesde() ;
                                    AV43mesHasta = ((web.Sdtpresentacion_1_18_retPerPago_periodo)((web.Sdtpresentacion_1_18_retPerPago)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Retperpagos().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_retPerPago_Periodos().elementAt(-1+AV45p)).getgxTv_Sdtpresentacion_1_18_retPerPago_periodo_Meshasta() ;
                                    AV40LegDedImporte = ((web.Sdtpresentacion_1_18_retPerPago_periodo)((web.Sdtpresentacion_1_18_retPerPago)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Retperpagos().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_retPerPago_Periodos().elementAt(-1+AV45p)).getgxTv_Sdtpresentacion_1_18_retPerPago_periodo_Montomensual() ;
                                    AV37LegDedDescrip = GXutil.trim( ((web.Sdtpresentacion_1_18_retPerPago)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Retperpagos().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_retPerPago_Descbasica()) ;
                                    if ( ! (GXutil.strcmp("", ((web.Sdtpresentacion_1_18_retPerPago)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Retperpagos().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_retPerPago_Descadicional())==0) )
                                    {
                                       AV37LegDedDescrip += ". " + GXutil.trim( ((web.Sdtpresentacion_1_18_retPerPago)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Retperpagos().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_retPerPago_Descadicional()) ;
                                    }
                                    while ( AV41mesDesde <= AV43mesHasta )
                                    {
                                       AV38LegDedFchDes = localUtil.ymdtod( AV8anio, AV41mesDesde, 1) ;
                                       AV39LegDedFchHas = GXutil.eomdate( AV38LegDedFchDes) ;
                                       new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "PAGO A CUENTA ", "")+GXutil.trim( AV35LegDedConCodigo)) ;
                                       AV58fechas.add(AV38LegDedFchDes, 0);
                                       GXv_boolean3[0] = AV23dioAlta ;
                                       new web.grabalegajodeduccion(remoteHandle, context).execute( AV17CliCod, AV26EmpCod, AV11LegNumero, AV35LegDedConCodigo, AV38LegDedFchDes, AV39LegDedFchHas, AV37LegDedDescrip, AV40LegDedImporte, AV34LegDedCodSiradig, "", GXv_boolean3) ;
                                       procesouploadsiradig_v_1_18.this.AV23dioAlta = GXv_boolean3[0] ;
                                       AV13altas = (short)(AV13altas+1) ;
                                       AV41mesDesde = (short)(AV41mesDesde+1) ;
                                    }
                                    AV45p = (short)(AV45p+1) ;
                                 }
                              }
                           }
                           AV32i = (short)(AV32i+1) ;
                        }
                        new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, "4") ;
                        if ( AV53vez == 2 )
                        {
                           new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, "5") ;
                           AV32i = (short)(1) ;
                           while ( AV32i <= AV47presentacion.getgxTv_Sdtpresentacion_1_18_Ganliqotrosempent().size() )
                           {
                              AV73GXV4 = 1 ;
                              AV72GXV3 = ((web.Sdtpresentacion_1_18_empEnt)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Ganliqotrosempent().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes() ;
                              while ( AV73GXV4 <= AV72GXV3.size() )
                              {
                                 AV56ingAp = (web.Sdtpresentacion_1_18_empEnt_ingAp)((web.Sdtpresentacion_1_18_empEnt_ingAp)AV72GXV3.elementAt(-1+AV73GXV4));
                                 AV38LegDedFchDes = localUtil.ymdtod( AV8anio, AV56ingAp.getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Mes(), 1) ;
                                 AV39LegDedFchHas = AV38LegDedFchDes ;
                                 GXt_char5 = AV35LegDedConCodigo ;
                                 GXt_char4 = AV35LegDedConCodigo ;
                                 GXv_char6[0] = GXt_char4 ;
                                 new web.otroemplos_codigoparam(remoteHandle, context).execute( GXv_char6) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char4 = GXv_char6[0] ;
                                 GXv_char2[0] = GXt_char5 ;
                                 new web.getparametro(remoteHandle, context).execute( AV17CliCod, GXt_char4, GXv_char2) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char5 = GXv_char2[0] ;
                                 AV35LegDedConCodigo = GXt_char5 ;
                                 GXt_char5 = AV37LegDedDescrip ;
                                 GXv_char6[0] = GXt_char5 ;
                                 new web.conceptogetdescri(remoteHandle, context).execute( AV17CliCod, AV35LegDedConCodigo, GXv_char6) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char5 = GXv_char6[0] ;
                                 AV37LegDedDescrip = GXt_char5 ;
                                 AV37LegDedDescrip = GXutil.trim( AV37LegDedDescrip) + " - " + GXutil.trim( GXutil.str( ((web.Sdtpresentacion_1_18_empEnt)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Ganliqotrosempent().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_empEnt_Cuit(), 12, 0)) ;
                                 AV40LegDedImporte = AV56ingAp.getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Obrasoc() ;
                                 new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "OTRO EMPL 1 CONCODIGO ", "")+GXutil.trim( AV35LegDedConCodigo)) ;
                                 AV58fechas.add(AV38LegDedFchDes, 0);
                                 if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV40LegDedImporte)==0) )
                                 {
                                    GXv_boolean3[0] = AV23dioAlta ;
                                    new web.grabalegajodeduccion(remoteHandle, context).execute( AV17CliCod, AV26EmpCod, AV11LegNumero, AV35LegDedConCodigo, AV38LegDedFchDes, AV39LegDedFchHas, AV37LegDedDescrip, AV40LegDedImporte, (byte)(0), "", GXv_boolean3) ;
                                    procesouploadsiradig_v_1_18.this.AV23dioAlta = GXv_boolean3[0] ;
                                    AV13altas = (short)(AV13altas+1) ;
                                 }
                                 GXt_char5 = AV35LegDedConCodigo ;
                                 GXt_char4 = AV35LegDedConCodigo ;
                                 GXv_char6[0] = GXt_char4 ;
                                 new web.otroemplsegsoc_codigoparam(remoteHandle, context).execute( GXv_char6) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char4 = GXv_char6[0] ;
                                 GXv_char2[0] = GXt_char5 ;
                                 new web.getparametro(remoteHandle, context).execute( AV17CliCod, GXt_char4, GXv_char2) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char5 = GXv_char2[0] ;
                                 AV35LegDedConCodigo = GXt_char5 ;
                                 GXt_char5 = AV37LegDedDescrip ;
                                 GXv_char6[0] = GXt_char5 ;
                                 new web.conceptogetdescri(remoteHandle, context).execute( AV17CliCod, AV35LegDedConCodigo, GXv_char6) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char5 = GXv_char6[0] ;
                                 AV37LegDedDescrip = GXt_char5 ;
                                 AV37LegDedDescrip = GXutil.trim( AV37LegDedDescrip) + " - " + GXutil.trim( GXutil.str( ((web.Sdtpresentacion_1_18_empEnt)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Ganliqotrosempent().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_empEnt_Cuit(), 12, 0)) ;
                                 AV40LegDedImporte = AV56ingAp.getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Segsoc() ;
                                 new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "OTRO EMPL 2 CONCODIGO ", "")+GXutil.trim( AV35LegDedConCodigo)) ;
                                 if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV40LegDedImporte)==0) )
                                 {
                                    GXv_boolean3[0] = AV23dioAlta ;
                                    new web.grabalegajodeduccion(remoteHandle, context).execute( AV17CliCod, AV26EmpCod, AV11LegNumero, AV35LegDedConCodigo, AV38LegDedFchDes, AV39LegDedFchHas, AV37LegDedDescrip, AV40LegDedImporte, (byte)(0), "", GXv_boolean3) ;
                                    procesouploadsiradig_v_1_18.this.AV23dioAlta = GXv_boolean3[0] ;
                                    AV13altas = (short)(AV13altas+1) ;
                                 }
                                 GXt_char5 = AV35LegDedConCodigo ;
                                 GXt_char4 = AV35LegDedConCodigo ;
                                 GXv_char6[0] = GXt_char4 ;
                                 new web.otroemplsindicato_codigoparam(remoteHandle, context).execute( GXv_char6) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char4 = GXv_char6[0] ;
                                 GXv_char2[0] = GXt_char5 ;
                                 new web.getparametro(remoteHandle, context).execute( AV17CliCod, GXt_char4, GXv_char2) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char5 = GXv_char2[0] ;
                                 AV35LegDedConCodigo = GXt_char5 ;
                                 GXt_char5 = AV37LegDedDescrip ;
                                 GXv_char6[0] = GXt_char5 ;
                                 new web.conceptogetdescri(remoteHandle, context).execute( AV17CliCod, AV35LegDedConCodigo, GXv_char6) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char5 = GXv_char6[0] ;
                                 AV37LegDedDescrip = GXt_char5 ;
                                 AV37LegDedDescrip = GXutil.trim( AV37LegDedDescrip) + " - " + GXutil.trim( GXutil.str( ((web.Sdtpresentacion_1_18_empEnt)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Ganliqotrosempent().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_empEnt_Cuit(), 12, 0)) ;
                                 AV40LegDedImporte = AV56ingAp.getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Sind() ;
                                 new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "OTRO EMPL 3 CONCODIGO ", "")+GXutil.trim( AV35LegDedConCodigo)) ;
                                 if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV40LegDedImporte)==0) )
                                 {
                                    GXv_boolean3[0] = AV23dioAlta ;
                                    new web.grabalegajodeduccion(remoteHandle, context).execute( AV17CliCod, AV26EmpCod, AV11LegNumero, AV35LegDedConCodigo, AV38LegDedFchDes, AV39LegDedFchHas, AV37LegDedDescrip, AV40LegDedImporte, (byte)(0), "", GXv_boolean3) ;
                                    procesouploadsiradig_v_1_18.this.AV23dioAlta = GXv_boolean3[0] ;
                                    AV13altas = (short)(AV13altas+1) ;
                                 }
                                 GXt_char5 = AV35LegDedConCodigo ;
                                 GXt_char4 = AV35LegDedConCodigo ;
                                 GXv_char6[0] = GXt_char4 ;
                                 new web.otroemplgananciabruta_codigoparam(remoteHandle, context).execute( GXv_char6) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char4 = GXv_char6[0] ;
                                 GXv_char2[0] = GXt_char5 ;
                                 new web.getparametro(remoteHandle, context).execute( AV17CliCod, GXt_char4, GXv_char2) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char5 = GXv_char2[0] ;
                                 AV35LegDedConCodigo = GXt_char5 ;
                                 GXt_char5 = AV37LegDedDescrip ;
                                 GXv_char6[0] = GXt_char5 ;
                                 new web.conceptogetdescri(remoteHandle, context).execute( AV17CliCod, AV35LegDedConCodigo, GXv_char6) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char5 = GXv_char6[0] ;
                                 AV37LegDedDescrip = GXt_char5 ;
                                 AV37LegDedDescrip = GXutil.trim( AV37LegDedDescrip) + " - " + GXutil.trim( GXutil.str( ((web.Sdtpresentacion_1_18_empEnt)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Ganliqotrosempent().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_empEnt_Cuit(), 12, 0)) ;
                                 AV40LegDedImporte = AV56ingAp.getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Ganbrut() ;
                                 new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "OTRO EMPL 4 CONCODIGO ", "")+GXutil.trim( AV35LegDedConCodigo)) ;
                                 if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV40LegDedImporte)==0) )
                                 {
                                    GXv_boolean3[0] = AV23dioAlta ;
                                    new web.grabalegajodeduccion(remoteHandle, context).execute( AV17CliCod, AV26EmpCod, AV11LegNumero, AV35LegDedConCodigo, AV38LegDedFchDes, AV39LegDedFchHas, AV37LegDedDescrip, AV40LegDedImporte, (byte)(0), "", GXv_boolean3) ;
                                    procesouploadsiradig_v_1_18.this.AV23dioAlta = GXv_boolean3[0] ;
                                    AV13altas = (short)(AV13altas+1) ;
                                 }
                                 GXt_char5 = AV35LegDedConCodigo ;
                                 GXt_char4 = AV35LegDedConCodigo ;
                                 GXv_char6[0] = GXt_char4 ;
                                 new web.otroemplretrnohab_codigoparam(remoteHandle, context).execute( GXv_char6) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char4 = GXv_char6[0] ;
                                 GXv_char2[0] = GXt_char5 ;
                                 new web.getparametro(remoteHandle, context).execute( AV17CliCod, GXt_char4, GXv_char2) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char5 = GXv_char2[0] ;
                                 AV35LegDedConCodigo = GXt_char5 ;
                                 GXt_char5 = AV37LegDedDescrip ;
                                 GXv_char6[0] = GXt_char5 ;
                                 new web.conceptogetdescri(remoteHandle, context).execute( AV17CliCod, AV35LegDedConCodigo, GXv_char6) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char5 = GXv_char6[0] ;
                                 AV37LegDedDescrip = GXt_char5 ;
                                 AV37LegDedDescrip = GXutil.trim( AV37LegDedDescrip) + " - " + GXutil.trim( GXutil.str( ((web.Sdtpresentacion_1_18_empEnt)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Ganliqotrosempent().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_empEnt_Cuit(), 12, 0)) ;
                                 AV40LegDedImporte = AV56ingAp.getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Retribnohab() ;
                                 new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "OTRO EMPL 5 CONCODIGO ", "")+GXutil.trim( AV35LegDedConCodigo)) ;
                                 if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV40LegDedImporte)==0) )
                                 {
                                    GXv_boolean3[0] = AV23dioAlta ;
                                    new web.grabalegajodeduccion(remoteHandle, context).execute( AV17CliCod, AV26EmpCod, AV11LegNumero, AV35LegDedConCodigo, AV38LegDedFchDes, AV39LegDedFchHas, AV37LegDedDescrip, AV40LegDedImporte, (byte)(0), "", GXv_boolean3) ;
                                    procesouploadsiradig_v_1_18.this.AV23dioAlta = GXv_boolean3[0] ;
                                    AV13altas = (short)(AV13altas+1) ;
                                 }
                                 GXt_char5 = AV35LegDedConCodigo ;
                                 GXt_char4 = AV35LegDedConCodigo ;
                                 GXv_char6[0] = GXt_char4 ;
                                 new web.otroemplsac_codigoparam(remoteHandle, context).execute( GXv_char6) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char4 = GXv_char6[0] ;
                                 GXv_char2[0] = GXt_char5 ;
                                 new web.getparametro(remoteHandle, context).execute( AV17CliCod, GXt_char4, GXv_char2) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char5 = GXv_char2[0] ;
                                 AV35LegDedConCodigo = GXt_char5 ;
                                 GXt_char5 = AV37LegDedDescrip ;
                                 GXv_char6[0] = GXt_char5 ;
                                 new web.conceptogetdescri(remoteHandle, context).execute( AV17CliCod, AV35LegDedConCodigo, GXv_char6) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char5 = GXv_char6[0] ;
                                 AV37LegDedDescrip = GXt_char5 ;
                                 AV37LegDedDescrip = GXutil.trim( AV37LegDedDescrip) + " - " + GXutil.trim( GXutil.str( ((web.Sdtpresentacion_1_18_empEnt)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Ganliqotrosempent().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_empEnt_Cuit(), 12, 0)) ;
                                 AV40LegDedImporte = AV56ingAp.getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Sac() ;
                                 new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "OTRO EMPL 6 CONCODIGO ", "")+GXutil.trim( AV35LegDedConCodigo)) ;
                                 if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV40LegDedImporte)==0) )
                                 {
                                    GXv_boolean3[0] = AV23dioAlta ;
                                    new web.grabalegajodeduccion(remoteHandle, context).execute( AV17CliCod, AV26EmpCod, AV11LegNumero, AV35LegDedConCodigo, AV38LegDedFchDes, AV39LegDedFchHas, AV37LegDedDescrip, AV40LegDedImporte, (byte)(0), "", GXv_boolean3) ;
                                    procesouploadsiradig_v_1_18.this.AV23dioAlta = GXv_boolean3[0] ;
                                    AV13altas = (short)(AV13altas+1) ;
                                 }
                                 GXt_char5 = AV35LegDedConCodigo ;
                                 GXt_char4 = AV35LegDedConCodigo ;
                                 GXv_char6[0] = GXt_char4 ;
                                 new web.otroemplhorasextrasgravadas_codigoparam(remoteHandle, context).execute( GXv_char6) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char4 = GXv_char6[0] ;
                                 GXv_char2[0] = GXt_char5 ;
                                 new web.getparametro(remoteHandle, context).execute( AV17CliCod, GXt_char4, GXv_char2) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char5 = GXv_char2[0] ;
                                 AV35LegDedConCodigo = GXt_char5 ;
                                 GXt_char5 = AV37LegDedDescrip ;
                                 GXv_char6[0] = GXt_char5 ;
                                 new web.conceptogetdescri(remoteHandle, context).execute( AV17CliCod, AV35LegDedConCodigo, GXv_char6) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char5 = GXv_char6[0] ;
                                 AV37LegDedDescrip = GXt_char5 ;
                                 AV37LegDedDescrip = GXutil.trim( AV37LegDedDescrip) + " - " + GXutil.trim( GXutil.str( ((web.Sdtpresentacion_1_18_empEnt)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Ganliqotrosempent().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_empEnt_Cuit(), 12, 0)) ;
                                 AV40LegDedImporte = AV56ingAp.getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Horasextgr() ;
                                 new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "OTRO EMPL 4 CONCODIGO ", "")+GXutil.trim( AV35LegDedConCodigo)) ;
                                 if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV40LegDedImporte)==0) )
                                 {
                                    GXv_boolean3[0] = AV23dioAlta ;
                                    new web.grabalegajodeduccion(remoteHandle, context).execute( AV17CliCod, AV26EmpCod, AV11LegNumero, AV35LegDedConCodigo, AV38LegDedFchDes, AV39LegDedFchHas, AV37LegDedDescrip, AV40LegDedImporte, (byte)(0), "", GXv_boolean3) ;
                                    procesouploadsiradig_v_1_18.this.AV23dioAlta = GXv_boolean3[0] ;
                                    AV13altas = (short)(AV13altas+1) ;
                                 }
                                 GXt_char5 = AV35LegDedConCodigo ;
                                 GXt_char4 = AV35LegDedConCodigo ;
                                 GXv_char6[0] = GXt_char4 ;
                                 new web.otroemplbonosprod_codigoparam(remoteHandle, context).execute( GXv_char6) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char4 = GXv_char6[0] ;
                                 GXv_char2[0] = GXt_char5 ;
                                 new web.getparametro(remoteHandle, context).execute( AV17CliCod, GXt_char4, GXv_char2) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char5 = GXv_char2[0] ;
                                 AV35LegDedConCodigo = GXt_char5 ;
                                 GXt_char5 = AV37LegDedDescrip ;
                                 GXv_char6[0] = GXt_char5 ;
                                 new web.conceptogetdescri(remoteHandle, context).execute( AV17CliCod, AV35LegDedConCodigo, GXv_char6) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char5 = GXv_char6[0] ;
                                 AV37LegDedDescrip = GXt_char5 ;
                                 AV37LegDedDescrip = GXutil.trim( AV37LegDedDescrip) + " - " + GXutil.trim( GXutil.str( ((web.Sdtpresentacion_1_18_empEnt)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Ganliqotrosempent().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_empEnt_Cuit(), 12, 0)) ;
                                 AV40LegDedImporte = AV56ingAp.getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Bonosprod() ;
                                 new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "OTRO EMPL 5 CONCODIGO ", "")+GXutil.trim( AV35LegDedConCodigo)) ;
                                 if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV40LegDedImporte)==0) )
                                 {
                                    GXv_boolean3[0] = AV23dioAlta ;
                                    new web.grabalegajodeduccion(remoteHandle, context).execute( AV17CliCod, AV26EmpCod, AV11LegNumero, AV35LegDedConCodigo, AV38LegDedFchDes, AV39LegDedFchHas, AV37LegDedDescrip, AV40LegDedImporte, (byte)(0), "", GXv_boolean3) ;
                                    procesouploadsiradig_v_1_18.this.AV23dioAlta = GXv_boolean3[0] ;
                                    AV13altas = (short)(AV13altas+1) ;
                                 }
                                 GXt_char5 = AV35LegDedConCodigo ;
                                 GXt_char4 = AV35LegDedConCodigo ;
                                 GXv_char6[0] = GXt_char4 ;
                                 new web.otroempfalloscaja_codigoparam(remoteHandle, context).execute( GXv_char6) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char4 = GXv_char6[0] ;
                                 GXv_char2[0] = GXt_char5 ;
                                 new web.getparametro(remoteHandle, context).execute( AV17CliCod, GXt_char4, GXv_char2) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char5 = GXv_char2[0] ;
                                 AV35LegDedConCodigo = GXt_char5 ;
                                 GXt_char5 = AV37LegDedDescrip ;
                                 GXv_char6[0] = GXt_char5 ;
                                 new web.conceptogetdescri(remoteHandle, context).execute( AV17CliCod, AV35LegDedConCodigo, GXv_char6) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char5 = GXv_char6[0] ;
                                 AV37LegDedDescrip = GXt_char5 ;
                                 AV37LegDedDescrip = GXutil.trim( AV37LegDedDescrip) + " - " + GXutil.trim( GXutil.str( ((web.Sdtpresentacion_1_18_empEnt)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Ganliqotrosempent().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_empEnt_Cuit(), 12, 0)) ;
                                 AV40LegDedImporte = AV56ingAp.getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Falloscaja() ;
                                 new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "OTRO EMPL 6 CONCODIGO ", "")+GXutil.trim( AV35LegDedConCodigo)) ;
                                 if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV40LegDedImporte)==0) )
                                 {
                                    GXv_boolean3[0] = AV23dioAlta ;
                                    new web.grabalegajodeduccion(remoteHandle, context).execute( AV17CliCod, AV26EmpCod, AV11LegNumero, AV35LegDedConCodigo, AV38LegDedFchDes, AV39LegDedFchHas, AV37LegDedDescrip, AV40LegDedImporte, (byte)(0), "", GXv_boolean3) ;
                                    procesouploadsiradig_v_1_18.this.AV23dioAlta = GXv_boolean3[0] ;
                                    AV13altas = (short)(AV13altas+1) ;
                                 }
                                 GXt_char5 = AV35LegDedConCodigo ;
                                 GXt_char4 = AV35LegDedConCodigo ;
                                 GXv_char6[0] = GXt_char4 ;
                                 new web.otroempcomsimnat_codigoparam(remoteHandle, context).execute( GXv_char6) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char4 = GXv_char6[0] ;
                                 GXv_char2[0] = GXt_char5 ;
                                 new web.getparametro(remoteHandle, context).execute( AV17CliCod, GXt_char4, GXv_char2) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char5 = GXv_char2[0] ;
                                 AV35LegDedConCodigo = GXt_char5 ;
                                 GXt_char5 = AV37LegDedDescrip ;
                                 GXv_char6[0] = GXt_char5 ;
                                 new web.conceptogetdescri(remoteHandle, context).execute( AV17CliCod, AV35LegDedConCodigo, GXv_char6) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char5 = GXv_char6[0] ;
                                 AV37LegDedDescrip = GXt_char5 ;
                                 AV37LegDedDescrip = GXutil.trim( AV37LegDedDescrip) + " - " + GXutil.trim( GXutil.str( ((web.Sdtpresentacion_1_18_empEnt)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Ganliqotrosempent().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_empEnt_Cuit(), 12, 0)) ;
                                 AV40LegDedImporte = AV56ingAp.getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Consimnat() ;
                                 new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "OTRO EMPL 7 CONCODIGO ", "")+GXutil.trim( AV35LegDedConCodigo)) ;
                                 if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV40LegDedImporte)==0) )
                                 {
                                    GXv_boolean3[0] = AV23dioAlta ;
                                    new web.grabalegajodeduccion(remoteHandle, context).execute( AV17CliCod, AV26EmpCod, AV11LegNumero, AV35LegDedConCodigo, AV38LegDedFchDes, AV39LegDedFchHas, AV37LegDedDescrip, AV40LegDedImporte, (byte)(0), "", GXv_boolean3) ;
                                    procesouploadsiradig_v_1_18.this.AV23dioAlta = GXv_boolean3[0] ;
                                    AV13altas = (short)(AV13altas+1) ;
                                 }
                                 GXt_char5 = AV35LegDedConCodigo ;
                                 GXt_char4 = AV35LegDedConCodigo ;
                                 GXv_char6[0] = GXt_char4 ;
                                 new web.otroemplley19101_codigoparam(remoteHandle, context).execute( GXv_char6) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char4 = GXv_char6[0] ;
                                 GXv_char2[0] = GXt_char5 ;
                                 new web.getparametro(remoteHandle, context).execute( AV17CliCod, GXt_char4, GXv_char2) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char5 = GXv_char2[0] ;
                                 AV35LegDedConCodigo = GXt_char5 ;
                                 GXt_char5 = AV37LegDedDescrip ;
                                 GXv_char6[0] = GXt_char5 ;
                                 new web.conceptogetdescri(remoteHandle, context).execute( AV17CliCod, AV35LegDedConCodigo, GXv_char6) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char5 = GXv_char6[0] ;
                                 AV37LegDedDescrip = GXt_char5 ;
                                 AV37LegDedDescrip = GXutil.trim( AV37LegDedDescrip) + " - " + GXutil.trim( GXutil.str( ((web.Sdtpresentacion_1_18_empEnt)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Ganliqotrosempent().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_empEnt_Cuit(), 12, 0)) ;
                                 AV40LegDedImporte = AV56ingAp.getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Suplemparticley19101() ;
                                 new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "OTRO EMPL 9 CONCODIGO ", "")+GXutil.trim( AV35LegDedConCodigo)) ;
                                 if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV40LegDedImporte)==0) )
                                 {
                                    GXv_boolean3[0] = AV23dioAlta ;
                                    new web.grabalegajodeduccion(remoteHandle, context).execute( AV17CliCod, AV26EmpCod, AV11LegNumero, AV35LegDedConCodigo, AV38LegDedFchDes, AV39LegDedFchHas, AV37LegDedDescrip, AV40LegDedImporte, (byte)(0), "", GXv_boolean3) ;
                                    procesouploadsiradig_v_1_18.this.AV23dioAlta = GXv_boolean3[0] ;
                                    AV13altas = (short)(AV13altas+1) ;
                                 }
                                 GXt_char5 = AV35LegDedConCodigo ;
                                 GXt_char4 = AV35LegDedConCodigo ;
                                 GXv_char6[0] = GXt_char4 ;
                                 new web.otroemplteletrabajo_codigoparam(remoteHandle, context).execute( GXv_char6) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char4 = GXv_char6[0] ;
                                 GXv_char2[0] = GXt_char5 ;
                                 new web.getparametro(remoteHandle, context).execute( AV17CliCod, GXt_char4, GXv_char2) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char5 = GXv_char2[0] ;
                                 AV35LegDedConCodigo = GXt_char5 ;
                                 GXt_char5 = AV37LegDedDescrip ;
                                 GXv_char6[0] = GXt_char5 ;
                                 new web.conceptogetdescri(remoteHandle, context).execute( AV17CliCod, AV35LegDedConCodigo, GXv_char6) ;
                                 procesouploadsiradig_v_1_18.this.GXt_char5 = GXv_char6[0] ;
                                 AV37LegDedDescrip = GXt_char5 ;
                                 AV37LegDedDescrip = GXutil.trim( AV37LegDedDescrip) + " - " + GXutil.trim( GXutil.str( ((web.Sdtpresentacion_1_18_empEnt)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Ganliqotrosempent().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_empEnt_Cuit(), 12, 0)) ;
                                 AV40LegDedImporte = AV56ingAp.getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Teletrabajoexento() ;
                                 new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "OTRO EMPL 10 CONCODIGO ", "")+GXutil.trim( AV35LegDedConCodigo)) ;
                                 if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV40LegDedImporte)==0) )
                                 {
                                    GXv_boolean3[0] = AV23dioAlta ;
                                    new web.grabalegajodeduccion(remoteHandle, context).execute( AV17CliCod, AV26EmpCod, AV11LegNumero, AV35LegDedConCodigo, AV38LegDedFchDes, AV39LegDedFchHas, AV37LegDedDescrip, AV40LegDedImporte, (byte)(0), "", GXv_boolean3) ;
                                    procesouploadsiradig_v_1_18.this.AV23dioAlta = GXv_boolean3[0] ;
                                    AV13altas = (short)(AV13altas+1) ;
                                 }
                                 AV73GXV4 = (int)(AV73GXV4+1) ;
                              }
                              AV32i = (short)(AV32i+1) ;
                           }
                           new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, "6") ;
                        }
                        new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, "7") ;
                        if ( AV53vez == 2 )
                        {
                           new web.destildargananciasfamiliares(remoteHandle, context).execute( AV17CliCod, AV26EmpCod, AV11LegNumero) ;
                           AV32i = (short)(1) ;
                           while ( AV32i <= AV47presentacion.getgxTv_Sdtpresentacion_1_18_Cargasfamilia().size() )
                           {
                              AV29FamTomaDeducImpGan = DecimalUtil.doubleToDec(((web.Sdtpresentacion_1_18_cargaFamilia)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Cargasfamilia().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_cargaFamilia_Porcentajededuccion()/ (double) (100)) ;
                              new web.actualizarfamiliarsiradig(remoteHandle, context).execute( AV17CliCod, AV26EmpCod, AV11LegNumero, GXutil.trim( GXutil.str( ((web.Sdtpresentacion_1_18_cargaFamilia)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Cargasfamilia().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_cargaFamilia_Nrodoc(), 12, 0)), ((web.Sdtpresentacion_1_18_cargaFamilia)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Cargasfamilia().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_cargaFamilia_Apellido(), ((web.Sdtpresentacion_1_18_cargaFamilia)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Cargasfamilia().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_cargaFamilia_Nombre(), ((web.Sdtpresentacion_1_18_cargaFamilia)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Cargasfamilia().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_cargaFamilia_Parentesco(), ((web.Sdtpresentacion_1_18_cargaFamilia)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Cargasfamilia().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac(), AV29FamTomaDeducImpGan, ((web.Sdtpresentacion_1_18_cargaFamilia)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Cargasfamilia().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_cargaFamilia_Mesdesde(), ((web.Sdtpresentacion_1_18_cargaFamilia)AV47presentacion.getgxTv_Sdtpresentacion_1_18_Cargasfamilia().elementAt(-1+AV32i)).getgxTv_Sdtpresentacion_1_18_cargaFamilia_Meshasta()) ;
                              AV32i = (short)(AV32i+1) ;
                           }
                           new web.seteardefaultcontinuaotroempleo(remoteHandle, context).execute( AV17CliCod, AV26EmpCod, AV11LegNumero) ;
                        }
                     }
                  }
               }
               AV31File.close();
            }
            else
            {
               AV27errores.add(httpContext.getMessage( "No se pudo abrir el archivo ", "")+GXutil.trim( A567ArchSirdigNameAndType), 0);
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "&errores.count ", "")+GXutil.trim( GXutil.str( AV27errores.size(), 9, 0))+httpContext.getMessage( " &vez ", "")+GXutil.trim( GXutil.str( AV53vez, 4, 0))) ;
            if ( ( AV27errores.size() == 0 ) && ( AV53vez == 2 ) )
            {
               A565ArchSiradigEstado = (short)(2) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, "9") ;
            }
            else
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, "10") ;
               if ( ( AV27errores.size() > 0 ) && ( AV53vez == 1 ) )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, "11") ;
                  if ( A565ArchSiradigEstado == 1 )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, "12") ;
                     A565ArchSiradigEstado = (short)(4) ;
                  }
                  if ( (GXutil.strcmp("", A566ArchSiradigError)==0) )
                  {
                     A566ArchSiradigError = AV27errores.toJSonString(false) ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, "13") ;
                  }
                  AV48seguir = false ;
               }
               else
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, "14") ;
                  if ( ( AV27errores.size() == 0 ) && ( AV53vez == 1 ) )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, "15") ;
                     new web.deletededucciones(remoteHandle, context).execute( AV17CliCod, AV26EmpCod, AV11LegNumero, AV8anio) ;
                     new web.setlegrecalcularliq(remoteHandle, context).execute( AV17CliCod, AV26EmpCod, AV11LegNumero, true) ;
                  }
               }
            }
            AV15ArchSiradigEstado = A565ArchSiradigEstado ;
            /* Using cursor P011W3 */
            pr_default.execute(1, new Object[] {Short.valueOf(A565ArchSiradigEstado), A566ArchSiradigError, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A85ArchSiradigFec});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("archivo_siradig");
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         AV53vez = (short)(AV53vez+1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, "16") ;
      }
      if ( AV27errores.size() > 0 )
      {
         AV25e = (short)(1) ;
         AV27errores.sort("");
         while ( AV25e <= AV27errores.size() )
         {
            if ( GXutil.strcmp((String)AV27errores.elementAt(-1+AV25e), AV49ultiError) == 0 )
            {
               AV27errores.removeItem(AV25e);
            }
            else
            {
               AV49ultiError = (String)AV27errores.elementAt(-1+AV25e) ;
               AV25e = (short)(AV25e+1) ;
            }
         }
      }
      else
      {
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = procesouploadsiradig_v_1_18.this.AV27errores;
      this.aP5[0] = procesouploadsiradig_v_1_18.this.AV13altas;
      Application.commitDataStores(context, remoteHandle, pr_default, "procesouploadsiradig_v_1_18");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV27errores = new GXSimpleCollection<String>(String.class, "internal", "");
      AV68Pgmname = "" ;
      AV12ahora = GXutil.resetTime( GXutil.nullDate() );
      scmdbuf = "" ;
      P011W2_A85ArchSiradigFec = new java.util.Date[] {GXutil.nullDate()} ;
      P011W2_A1EmpCod = new short[1] ;
      P011W2_A3CliCod = new int[1] ;
      P011W2_A562ArchSiradigFile = new String[] {""} ;
      P011W2_A565ArchSiradigEstado = new short[1] ;
      P011W2_A566ArchSiradigError = new String[] {""} ;
      P011W2_A563ArchSiradigType = new String[] {""} ;
      P011W2_A564ArchSiradigName = new String[] {""} ;
      A85ArchSiradigFec = GXutil.resetTime( GXutil.nullDate() );
      A562ArchSiradigFile = "" ;
      A566ArchSiradigError = "" ;
      A563ArchSiradigType = "" ;
      A564ArchSiradigName = "" ;
      A567ArchSirdigNameAndType = "" ;
      AV9ArchSiradigFile = "" ;
      AV31File = new com.genexus.util.GXFile();
      AV55XML = "" ;
      AV47presentacion = new web.Sdtpresentacion_1_18(remoteHandle, context);
      GXv_int1 = new int[1] ;
      AV57legnumeros = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV35LegDedConCodigo = "" ;
      AV36LegDedConDescrip = "" ;
      AV37LegDedDescrip = "" ;
      AV40LegDedImporte = DecimalUtil.ZERO ;
      AV38LegDedFchDes = GXutil.nullDate() ;
      AV39LegDedFchHas = GXutil.nullDate() ;
      AV58fechas = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "");
      AV33LegDedCodMot = "" ;
      AV65numeroDocFamiliar = "" ;
      AV60apellido = "" ;
      AV63nacFecha = GXutil.nullDate() ;
      AV29FamTomaDeducImpGan = DecimalUtil.ZERO ;
      AV70GXV1 = new GXBaseCollection<web.Sdtpresentacion_1_18_deduccion_detalle>(web.Sdtpresentacion_1_18_deduccion_detalle.class, "presentacion_1_18.deduccion.detalle", "", remoteHandle);
      AV21detalle = new web.Sdtpresentacion_1_18_deduccion_detalle(remoteHandle, context);
      AV51valorSplit = new GXSimpleCollection<String>(String.class, "internal", "");
      AV64palabras = new GXSimpleCollection<String>(String.class, "internal", "");
      AV61nombre = "" ;
      AV72GXV3 = new GXBaseCollection<web.Sdtpresentacion_1_18_empEnt_ingAp>(web.Sdtpresentacion_1_18_empEnt_ingAp.class, "presentacion_1_18.empEnt.ingAp", "", remoteHandle);
      AV56ingAp = new web.Sdtpresentacion_1_18_empEnt_ingAp(remoteHandle, context);
      GXt_char4 = "" ;
      GXv_char2 = new String[1] ;
      GXt_char5 = "" ;
      GXv_char6 = new String[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV49ultiError = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.procesouploadsiradig_v_1_18__default(),
         new Object[] {
             new Object[] {
            P011W2_A85ArchSiradigFec, P011W2_A1EmpCod, P011W2_A3CliCod, P011W2_A562ArchSiradigFile, P011W2_A565ArchSiradigEstado, P011W2_A566ArchSiradigError, P011W2_A563ArchSiradigType, P011W2_A564ArchSiradigName
            }
            , new Object[] {
            }
         }
      );
      AV68Pgmname = "ProcesoUploadSiradig_V_1_18" ;
      /* GeneXus formulas. */
      AV68Pgmname = "ProcesoUploadSiradig_V_1_18" ;
      Gx_err = (short)(0) ;
   }

   private byte AV34LegDedCodSiradig ;
   private short AV26EmpCod ;
   private short AV13altas ;
   private short AV53vez ;
   private short A1EmpCod ;
   private short A565ArchSiradigEstado ;
   private short AV8anio ;
   private short AV32i ;
   private short AV45p ;
   private short AV41mesDesde ;
   private short AV43mesHasta ;
   private short AV42MesFechaAporte ;
   private short AV62parentesco ;
   private short AV15ArchSiradigEstado ;
   private short AV25e ;
   private short Gx_err ;
   private int AV17CliCod ;
   private int AV46ParmLegNumero ;
   private int A3CliCod ;
   private int AV11LegNumero ;
   private int GXv_int1[] ;
   private int AV71GXV2 ;
   private int AV59porcentajeDeduccion ;
   private int AV73GXV4 ;
   private long AV10LegCUIL ;
   private java.math.BigDecimal AV40LegDedImporte ;
   private java.math.BigDecimal AV29FamTomaDeducImpGan ;
   private String AV68Pgmname ;
   private String scmdbuf ;
   private String A563ArchSiradigType ;
   private String AV35LegDedConCodigo ;
   private String AV33LegDedCodMot ;
   private String AV65numeroDocFamiliar ;
   private String GXt_char4 ;
   private String GXv_char2[] ;
   private String GXt_char5 ;
   private String GXv_char6[] ;
   private java.util.Date AV16ArchSiradigFec ;
   private java.util.Date AV12ahora ;
   private java.util.Date A85ArchSiradigFec ;
   private java.util.Date AV38LegDedFchDes ;
   private java.util.Date AV39LegDedFchHas ;
   private java.util.Date AV63nacFecha ;
   private boolean AV48seguir ;
   private boolean AV28existeConcepto ;
   private boolean AV23dioAlta ;
   private boolean GXv_boolean3[] ;
   private String A562ArchSiradigFile ;
   private String AV9ArchSiradigFile ;
   private String A566ArchSiradigError ;
   private String A564ArchSiradigName ;
   private String A567ArchSirdigNameAndType ;
   private String AV55XML ;
   private String AV36LegDedConDescrip ;
   private String AV37LegDedDescrip ;
   private String AV60apellido ;
   private String AV61nombre ;
   private String AV49ultiError ;
   private GXSimpleCollection<Integer> AV57legnumeros ;
   private com.genexus.util.GXFile AV31File ;
   private short[] aP5 ;
   private GXSimpleCollection<String>[] aP4 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P011W2_A85ArchSiradigFec ;
   private short[] P011W2_A1EmpCod ;
   private int[] P011W2_A3CliCod ;
   private String[] P011W2_A562ArchSiradigFile ;
   private short[] P011W2_A565ArchSiradigEstado ;
   private String[] P011W2_A566ArchSiradigError ;
   private String[] P011W2_A563ArchSiradigType ;
   private String[] P011W2_A564ArchSiradigName ;
   private GXSimpleCollection<String> AV51valorSplit ;
   private GXSimpleCollection<String> AV64palabras ;
   private GXSimpleCollection<String> AV27errores ;
   private GXSimpleCollection<java.util.Date> AV58fechas ;
   private GXBaseCollection<web.Sdtpresentacion_1_18_empEnt_ingAp> AV72GXV3 ;
   private GXBaseCollection<web.Sdtpresentacion_1_18_deduccion_detalle> AV70GXV1 ;
   private web.Sdtpresentacion_1_18 AV47presentacion ;
   private web.Sdtpresentacion_1_18_empEnt_ingAp AV56ingAp ;
   private web.Sdtpresentacion_1_18_deduccion_detalle AV21detalle ;
}

final  class procesouploadsiradig_v_1_18__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P011W2", "SELECT ArchSiradigFec, EmpCod, CliCod, ArchSiradigFile, ArchSiradigEstado, ArchSiradigError, ArchSiradigType, ArchSiradigName FROM archivo_siradig WHERE CliCod = ? and EmpCod = ? and ArchSiradigFec = ? ORDER BY CliCod, EmpCod, ArchSiradigFec  FOR UPDATE OF archivo_siradig",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P011W3", "SAVEPOINT gxupdate;UPDATE archivo_siradig SET ArchSiradigEstado=?, ArchSiradigError=?  WHERE CliCod = ? AND EmpCod = ? AND ArchSiradigFec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getBLOBFile(4, rslt.getString(7, 20), rslt.getVarchar(8));
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDateTime(3, (java.util.Date)parms[2], false);
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setDateTime(5, (java.util.Date)parms[4], false);
               return;
      }
   }

}

