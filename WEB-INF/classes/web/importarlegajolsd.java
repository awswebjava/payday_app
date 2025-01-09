package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importarlegajolsd extends GXProcedure
{
   public importarlegajolsd( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importarlegajolsd.class ), "" );
   }

   public importarlegajolsd( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            short aP2 ,
                            short aP3 ,
                            GXSimpleCollection<String>[] aP4 )
   {
      importarlegajolsd.this.aP5 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        short aP3 ,
                        GXSimpleCollection<String>[] aP4 ,
                        short[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             short aP3 ,
                             GXSimpleCollection<String>[] aP4 ,
                             short[] aP5 )
   {
      importarlegajolsd.this.AV13CliCod = aP0;
      importarlegajolsd.this.AV17EmpCod = aP1;
      importarlegajolsd.this.AV48ImpLiqSec = aP2;
      importarlegajolsd.this.AV47ImpLiqLSDSec = aP3;
      importarlegajolsd.this.aP4 = aP4;
      importarlegajolsd.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, "1") ;
      AV69vez = (short)(1) ;
      AV63seguir = true ;
      AV50IsOk = true ;
      AV93scrapearCuil = GXutil.boolval( new web.getparametro(remoteHandle, context).executeUdp( AV13CliCod, new web.scrapecuil_codigoparam(remoteHandle, context).executeUdp( ))) ;
      while ( ( AV69vez <= 2 ) && ( AV63seguir ) )
      {
         if ( AV19errores.size() > 0 )
         {
            if (true) break;
         }
         AV19errores.clear();
         AV10ahora = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
         AV105GXLvl15 = (byte)(0) ;
         /* Using cursor P027H2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV17EmpCod), Short.valueOf(AV48ImpLiqSec), Short.valueOf(AV47ImpLiqLSDSec)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A704ImpLiqLSDSec = P027H2_A704ImpLiqLSDSec[0] ;
            A88ImpLiqSec = P027H2_A88ImpLiqSec[0] ;
            A1EmpCod = P027H2_A1EmpCod[0] ;
            A3CliCod = P027H2_A3CliCod[0] ;
            A706ImpLiqLSDFileName = P027H2_A706ImpLiqLSDFileName[0] ;
            A707ImpLiqLSDFileType = P027H2_A707ImpLiqLSDFileType[0] ;
            A705ImpLiqLSDFile = P027H2_A705ImpLiqLSDFile[0] ;
            A708ImpLiqLSDFileNameAndType = P027H2_A708ImpLiqLSDFileNameAndType[0] ;
            AV105GXLvl15 = (byte)(1) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, "2") ;
            AV25File.setSource( A705ImpLiqLSDFile );
            if ( AV25File.exists() )
            {
               AV23f = (short)(0) ;
               AV68varcharcollection = new GXSimpleCollection<String>(String.class, "internal", "", AV25File.readAllLines()) ;
               AV14completo = false ;
               AV11algunoCompleto = false ;
               AV106GXV1 = 1 ;
               while ( AV106GXV1 <= AV68varcharcollection.size() )
               {
                  AV26fileLine = (String)AV68varcharcollection.elementAt(-1+AV106GXV1) ;
                  AV23f = (short)(AV23f+1) ;
                  AV20errorFormato = "" ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "fila ", "")+GXutil.trim( GXutil.str( AV23f, 4, 0))+" "+GXutil.trim( AV26fileLine)) ;
                  AV66tipoRegistro = GXutil.trim( GXutil.substring( AV26fileLine, 1, 2)) ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "&tipoRegistro ", "")+GXutil.trim( AV66tipoRegistro)) ;
                  if ( GXutil.strcmp(AV66tipoRegistro, "01") == 0 )
                  {
                     AV41ImpLiqDetLiqClase = GXutil.trim( GXutil.substring( AV26fileLine, 22, 1)) ;
                     AV76ImpLiqDetPer = GXutil.trim( GXutil.substring( AV26fileLine, 16, 6)) ;
                     AV59registro1Hay = true ;
                     AV78LiqPerAno = (short)(GXutil.lval( GXutil.substring( AV76ImpLiqDetPer, 1, 4))) ;
                     AV79LiqPerMes = (byte)(GXutil.lval( GXutil.substring( AV76ImpLiqDetPer, 5, 2))) ;
                     AV77fecha = localUtil.ymdtod( AV78LiqPerAno, AV79LiqPerMes, 1) ;
                  }
                  else
                  {
                     if ( GXutil.strcmp(AV66tipoRegistro, "02") == 0 )
                     {
                        AV11algunoCompleto = true ;
                        AV37ImpLiqDetCUIL = GXutil.trim( GXutil.substring( AV26fileLine, 3, 11)) ;
                        AV40ImpLiqDetLegId = GXutil.trim( GXutil.substring( AV26fileLine, 14, 10)) ;
                        AV33ImpLiqDetCBU = GXutil.trim( GXutil.substring( AV26fileLine, 74, 22)) ;
                        AV81formaDePago = GXutil.trim( GXutil.substring( AV26fileLine, 115, 1)) ;
                        AV24fechaPago = GXutil.trim( GXutil.substring( AV26fileLine, 99, 8)) ;
                        AV14completo = true ;
                        AV60registro2Hay = true ;
                     }
                     else
                     {
                        if ( GXutil.strcmp(AV66tipoRegistro, "03") == 0 )
                        {
                           AV44ImpLiqDetSigno = GXutil.trim( GXutil.substring( AV26fileLine, 45, 1)) ;
                           AV39ImpLiqDetImp = GXutil.trim( GXutil.substring( AV26fileLine, 30, 15)) ;
                           AV37ImpLiqDetCUIL = GXutil.trim( GXutil.substring( AV26fileLine, 3, 11)) ;
                           AV61registro3Hay = true ;
                           AV14completo = true ;
                        }
                        else
                        {
                           if ( GXutil.strcmp(AV66tipoRegistro, "04") == 0 )
                           {
                              AV14completo = true ;
                              AV62registro4Hay = true ;
                              AV37ImpLiqDetCUIL = GXutil.trim( GXutil.substring( AV26fileLine, 3, 11)) ;
                              AV83ZonCod = GXutil.trim( GXutil.substring( AV26fileLine, 34, 2)) ;
                              GXv_char1[0] = AV86ZonDescrip ;
                              GXv_boolean2[0] = false ;
                              new web.getzona(remoteHandle, context).execute( AV83ZonCod, GXv_char1, GXv_boolean2) ;
                              importarlegajolsd.this.AV86ZonDescrip = GXv_char1[0] ;
                              AV87MprCod = GXutil.trim( GXutil.substring( AV26fileLine, 29, 3)) ;
                              GXv_char1[0] = AV85MprDescrip ;
                              GXv_boolean2[0] = false ;
                              new web.getmodalidad(remoteHandle, context).execute( AV87MprCod, GXv_char1, GXv_boolean2) ;
                              importarlegajolsd.this.AV85MprDescrip = GXv_char1[0] ;
                              AV89LSD4Conyuge_14_1 = GXutil.trim( GXutil.substring( AV26fileLine, 14, 1)) ;
                              AV94LSD4MarcaCCT_17_1 = GXutil.trim( GXutil.substring( AV26fileLine, 17, 1)) ;
                              AV101MigrLegObraSocial = GXutil.trim( GXutil.substring( AV26fileLine, 63, 6)) ;
                           }
                        }
                     }
                  }
                  new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "completo ", "")+GXutil.trim( GXutil.booltostr( AV14completo))) ;
                  if ( AV14completo )
                  {
                     if ( GXutil.strcmp(AV66tipoRegistro, "02") == 0 )
                     {
                        if ( AV69vez == 1 )
                        {
                           if ( (GXutil.strcmp("", AV66tipoRegistro)==0) || (GXutil.strcmp("", AV37ImpLiqDetCUIL)==0) )
                           {
                              if ( (GXutil.strcmp("", AV66tipoRegistro)==0) )
                              {
                                 AV20errorFormato = httpContext.getMessage( "Tipo de Registro vacío.", "") ;
                              }
                              if ( (GXutil.strcmp("", AV37ImpLiqDetCUIL)==0) )
                              {
                                 AV20errorFormato += httpContext.getMessage( "CUIL vacío.", "") ;
                              }
                              new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "fi 1 ", "")) ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                              if (true) break;
                           }
                           else
                           {
                              AV65tipoDeRegistroInvalido = false ;
                              GXv_boolean2[0] = AV21esNumero ;
                              new web.esnumero(remoteHandle, context).execute( AV66tipoRegistro, GXv_boolean2) ;
                              importarlegajolsd.this.AV21esNumero = GXv_boolean2[0] ;
                              if ( ! AV21esNumero )
                              {
                                 AV65tipoDeRegistroInvalido = true ;
                              }
                              else
                              {
                                 if ( CommonUtil.decimalVal( AV66tipoRegistro, ".").doubleValue() > 5 )
                                 {
                                    AV65tipoDeRegistroInvalido = true ;
                                 }
                              }
                              if ( AV65tipoDeRegistroInvalido )
                              {
                                 AV20errorFormato = httpContext.getMessage( "Tipo de Registro Inválido ", "") + AV66tipoRegistro ;
                                 new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "fi 2", "")) ;
                                 /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                                 S111 ();
                                 if ( returnInSub )
                                 {
                                    pr_default.close(0);
                                    returnInSub = true;
                                    cleanup();
                                    if (true) return;
                                 }
                                 if (true) break;
                              }
                              if ( ! (GXutil.strcmp("", AV37ImpLiqDetCUIL)==0) )
                              {
                                 GXv_boolean2[0] = AV21esNumero ;
                                 new web.esnumero(remoteHandle, context).execute( AV37ImpLiqDetCUIL, GXv_boolean2) ;
                                 importarlegajolsd.this.AV21esNumero = GXv_boolean2[0] ;
                                 if ( ! AV21esNumero )
                                 {
                                    AV20errorFormato = httpContext.getMessage( "Nro de liquidación inválido ", "") + AV37ImpLiqDetCUIL ;
                                    new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "fi 5", "")) ;
                                    /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                                    S111 ();
                                    if ( returnInSub )
                                    {
                                       pr_default.close(0);
                                       returnInSub = true;
                                       cleanup();
                                       if (true) return;
                                    }
                                    if (true) break;
                                 }
                              }
                           }
                        }
                        else
                        {
                           new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "alta &ImpLiqDetCUIL ", "")+AV37ImpLiqDetCUIL+httpContext.getMessage( " &ImpLiqLSDSec ", "")+GXutil.trim( GXutil.str( AV47ImpLiqLSDSec, 4, 0))) ;
                           /* Execute user subroutine: 'LOAD KEY' */
                           S171 ();
                           if ( returnInSub )
                           {
                              pr_default.close(0);
                              returnInSub = true;
                              cleanup();
                              if (true) return;
                           }
                           /* Execute user subroutine: 'ASIGNAR 02' */
                           S161 ();
                           if ( returnInSub )
                           {
                              pr_default.close(0);
                              returnInSub = true;
                              cleanup();
                              if (true) return;
                           }
                           /* Execute user subroutine: 'SAVE' */
                           S181 ();
                           if ( returnInSub )
                           {
                              pr_default.close(0);
                              returnInSub = true;
                              cleanup();
                              if (true) return;
                           }
                        }
                     }
                     else
                     {
                        if ( AV69vez > 1 )
                        {
                           if ( ( GXutil.strcmp(AV66tipoRegistro, "03") == 0 ) && ( GXutil.strcmp(AV44ImpLiqDetSigno, httpContext.getMessage( "C", "")) == 0 ) && ! (DecimalUtil.compareTo(DecimalUtil.ZERO, CommonUtil.decimalVal( AV39ImpLiqDetImp, "."))==0) )
                           {
                              /* Execute user subroutine: 'LOAD KEY' */
                              S171 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                              /* Execute user subroutine: 'ASIGNAR 03' */
                              S121 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                              /* Execute user subroutine: 'SAVE' */
                              S181 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                           }
                           else
                           {
                              if ( GXutil.strcmp(AV66tipoRegistro, "04") == 0 )
                              {
                                 /* Execute user subroutine: 'LOAD KEY' */
                                 S171 ();
                                 if ( returnInSub )
                                 {
                                    pr_default.close(0);
                                    returnInSub = true;
                                    cleanup();
                                    if (true) return;
                                 }
                                 /* Execute user subroutine: 'ASIGNAR 04' */
                                 S141 ();
                                 if ( returnInSub )
                                 {
                                    pr_default.close(0);
                                    returnInSub = true;
                                    cleanup();
                                    if (true) return;
                                 }
                                 /* Execute user subroutine: 'SAVE' */
                                 S181 ();
                                 if ( returnInSub )
                                 {
                                    pr_default.close(0);
                                    returnInSub = true;
                                    cleanup();
                                    if (true) return;
                                 }
                              }
                           }
                        }
                     }
                     AV14completo = false ;
                     if ( ! AV50IsOk )
                     {
                        if (true) break;
                     }
                  }
                  AV106GXV1 = (int)(AV106GXV1+1) ;
               }
               if ( ! AV11algunoCompleto )
               {
                  AV20errorFormato = "" ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "fi 9", "")) ;
                  /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                  S111 ();
                  if ( returnInSub )
                  {
                     pr_default.close(0);
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
               AV25File.close();
            }
            else
            {
               AV19errores.add(httpContext.getMessage( "No se pudo abrir el archivo de LSD ", "")+GXutil.trim( A708ImpLiqLSDFileNameAndType), 0);
            }
            if ( ( AV19errores.size() == 0 ) && ( AV69vez == 2 ) )
            {
            }
            else
            {
               if ( ( AV19errores.size() > 0 ) && ( AV69vez == 1 ) )
               {
                  AV63seguir = false ;
               }
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         if ( AV105GXLvl15 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "No se encuentra el registro del archivo LSD ", "")+GXutil.trim( GXutil.str( AV13CliCod, 6, 0))+"/"+GXutil.trim( GXutil.str( AV17EmpCod, 4, 0))+"/"+GXutil.trim( GXutil.str( AV48ImpLiqSec, 4, 0))+"/"+GXutil.trim( GXutil.str( AV47ImpLiqLSDSec, 4, 0))) ;
            AV19errores.add(httpContext.getMessage( "No se encuentra el registro del archivo LSD ", "")+GXutil.trim( GXutil.str( AV13CliCod, 6, 0))+"/"+GXutil.trim( GXutil.str( AV17EmpCod, 4, 0))+"/"+GXutil.trim( GXutil.str( AV48ImpLiqSec, 4, 0))+"/"+GXutil.trim( GXutil.str( AV47ImpLiqLSDSec, 4, 0)), 0);
         }
         if ( ! AV50IsOk )
         {
            if (true) break;
         }
         if ( AV69vez == 1 )
         {
            if ( ! AV59registro1Hay || ! AV60registro2Hay || ! AV61registro3Hay || ! AV62registro4Hay )
            {
               AV20errorFormato = httpContext.getMessage( "No hay registro", "") ;
               if ( ! AV59registro1Hay )
               {
                  AV20errorFormato += " 01" ;
               }
               if ( ! AV60registro2Hay )
               {
                  AV20errorFormato += " 02" ;
               }
               if ( ! AV61registro3Hay )
               {
                  AV20errorFormato += " 03" ;
               }
               if ( ! AV62registro4Hay )
               {
                  AV20errorFormato += " 04" ;
               }
               new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "fi 10", "")) ;
               /* Execute user subroutine: 'FORMATO INVÁLIDO' */
               S111 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
         }
         else
         {
            GXv_objcol_svchar3[0] = AV92auxErrores ;
            GXv_objcol_svchar4[0] = AV91auxWarnings ;
            new web.validarregistromigracion(remoteHandle, context).execute( AV13CliCod, AV17EmpCod, 0, false, false, AV47ImpLiqLSDSec, GXv_objcol_svchar3, GXv_objcol_svchar4) ;
            AV92auxErrores = GXv_objcol_svchar3[0] ;
            AV91auxWarnings = GXv_objcol_svchar4[0] ;
         }
         AV69vez = (short)(AV69vez+1) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "isok", "")+GXutil.trim( GXutil.booltostr( AV50IsOk))) ;
      if ( AV19errores.size() > 0 )
      {
         AV16e = (short)(1) ;
         AV19errores.sort("");
         while ( AV16e <= AV19errores.size() )
         {
            if ( GXutil.strcmp((String)AV19errores.elementAt(-1+AV16e), AV9ultiError) == 0 )
            {
               AV19errores.removeItem(AV16e);
            }
            else
            {
               AV9ultiError = (String)AV19errores.elementAt(-1+AV16e) ;
               AV16e = (short)(AV16e+1) ;
            }
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'FORMATO INVÁLIDO' Routine */
      returnInSub = false ;
      AV50IsOk = false ;
      AV18error = httpContext.getMessage( "Archivo con formato inválido ", "") ;
      if ( ! (GXutil.strcmp("", AV20errorFormato)==0) )
      {
         AV18error += "(" + GXutil.trim( AV20errorFormato) + ")" ;
      }
      AV19errores.add(AV18error, 0);
      AV19errores.add(AV26fileLine, 0);
      new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "formainv ", "")+AV18error) ;
   }

   public void S121( )
   {
      /* 'ASIGNAR 03' Routine */
      returnInSub = false ;
      AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrarchsec( AV47ImpLiqLSDSec );
      AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrvalcadasave( false );
      new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "asignar3 existe ", "")+GXutil.trim( GXutil.booltostr( AV22existe))+httpContext.getMessage( " &importacion_legajo.MigrLegId ", "")+AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegid()) ;
      if ( (GXutil.strcmp("", AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegid())==0) )
      {
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegid( AV37ImpLiqDetCUIL );
         new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "&importacion_legajo.MigrLegId.SetEmpty()", "")) ;
      }
      if ( (GXutil.strcmp("", AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegcuil())==0) )
      {
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegcuil( AV37ImpLiqDetCUIL );
      }
      if ( (GXutil.strcmp("", AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegapellido())==0) )
      {
         /* Execute user subroutine: 'SCRAPE CUIL' */
         S131 ();
         if (returnInSub) return;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV104Pgmname, httpContext.getMessage( "&importacion_legajo.MigrLegMarcaCCT ", "")+AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegmarcacct()) ;
      if ( ( GXutil.strcmp(AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegmarcacct(), "1") == 0 ) && ( ! (GXutil.strcmp("", AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegconvenio())==0) && ( GXutil.strcmp(GXutil.upper( AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegconvenio()), GXutil.upper( new web.textofueradeconvenio(remoteHandle, context).executeUdp( AV13CliCod))) != 0 ) ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV104Pgmname, httpContext.getMessage( "borra", "")) ;
         GXv_Sdtimportacion_legajo5[0] = AV49importacion_legajo;
         new web.asignarmigrsueldosbc(remoteHandle, context).execute( GXv_Sdtimportacion_legajo5, "", AV77fecha) ;
         AV49importacion_legajo = GXv_Sdtimportacion_legajo5[0] ;
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegbanco( "" );
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegbasico( DecimalUtil.ZERO );
      }
      else
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV104Pgmname, httpContext.getMessage( "llama a asignar &ImpLiqDetImp ", "")+GXutil.trim( AV39ImpLiqDetImp)) ;
         GXv_Sdtimportacion_legajo5[0] = AV49importacion_legajo;
         new web.asignarmigrsueldosbc(remoteHandle, context).execute( GXv_Sdtimportacion_legajo5, AV39ImpLiqDetImp, AV77fecha) ;
         AV49importacion_legajo = GXv_Sdtimportacion_legajo5[0] ;
      }
      GXt_date6 = AV82predetIngFecha ;
      GXv_date7[0] = GXt_date6 ;
      new web.fecingpredetimpor(remoteHandle, context).execute( GXv_date7) ;
      importarlegajolsd.this.GXt_date6 = GXv_date7[0] ;
      AV82predetIngFecha = GXt_date6 ;
      if ( GXutil.dateCompare(GXutil.resetTime(AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegfecingreso()), GXutil.resetTime(AV82predetIngFecha)) || GXutil.resetTime(AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegfecingreso()).before( GXutil.resetTime( AV80anteriorFecha )) )
      {
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegfecingreso( AV77fecha );
      }
   }

   public void S141( )
   {
      /* 'ASIGNAR 04' Routine */
      returnInSub = false ;
      AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrarchsec( AV47ImpLiqLSDSec );
      AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrvalcadasave( false );
      AV8algunaLineaHay = true ;
      if ( ! (GXutil.strcmp("", AV86ZonDescrip)==0) )
      {
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegzona( AV86ZonDescrip );
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegzonadef( false );
         AV84que = httpContext.getMessage( "Zona", "") ;
         /* Execute user subroutine: 'SACAR WARNING DEFAULT' */
         S151 ();
         if (returnInSub) return;
      }
      if ( ! (GXutil.strcmp("", AV101MigrLegObraSocial)==0) && ( GXutil.strcmp(GXutil.trim( AV101MigrLegObraSocial), "000000") != 0 ) )
      {
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegobrasocial( AV101MigrLegObraSocial );
      }
      AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegmarcacct( AV94LSD4MarcaCCT_17_1 );
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV104Pgmname, httpContext.getMessage( "&LSD4MarcaCCT_17_1 ", "")+AV94LSD4MarcaCCT_17_1+httpContext.getMessage( " &importacion_legajo.MigrLegConvenio ", "")+AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegconvenio()) ;
      if ( ( GXutil.strcmp(AV94LSD4MarcaCCT_17_1, "1") == 0 ) && ( ! (GXutil.strcmp("", AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegconvenio())==0) && ( GXutil.strcmp(GXutil.upper( AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegconvenio()), GXutil.upper( new web.textofueradeconvenio(remoteHandle, context).executeUdp( AV13CliCod))) != 0 ) ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegbasico( DecimalUtil.ZERO );
         GXv_Sdtimportacion_legajo5[0] = AV49importacion_legajo;
         new web.asignarmigrsueldosbc(remoteHandle, context).execute( GXv_Sdtimportacion_legajo5, "", AV77fecha) ;
         AV49importacion_legajo = GXv_Sdtimportacion_legajo5[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV104Pgmname, httpContext.getMessage( "borra", "")) ;
      }
      if ( GXutil.strcmp(AV89LSD4Conyuge_14_1, "1") == 0 )
      {
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegestadocivil( httpContext.getMessage( "CASADO", "") );
      }
      else
      {
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegestadocivil( httpContext.getMessage( "SOLTERO", "") );
      }
      AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegestadocivildef( false );
      AV84que = httpContext.getMessage( "Estado Civil", "") ;
      /* Execute user subroutine: 'SACAR WARNING DEFAULT' */
      S151 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", AV85MprDescrip)==0) )
      {
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegmodalidad( AV85MprDescrip );
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegmodalidaddef( false );
         AV84que = httpContext.getMessage( "Modalidad", "") ;
         /* Execute user subroutine: 'SACAR WARNING DEFAULT' */
         S151 ();
         if (returnInSub) return;
      }
   }

   public void S161( )
   {
      /* 'ASIGNAR 02' Routine */
      returnInSub = false ;
      AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrarchsec( AV47ImpLiqLSDSec );
      AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrvalcadasave( false );
      AV8algunaLineaHay = true ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "Set record values &importacion_legajo.MigrLegId ", "")+AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegid()) ;
      if ( (GXutil.strcmp("", AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegid())==0) || ( GXutil.strSearch( AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegid(), new web.migrtidtemppalabra(remoteHandle, context).executeUdp( ), 1) != 0 ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "&ImpLiqDetLegId ", "")+AV40ImpLiqDetLegId) ;
         if ( ! (GXutil.strcmp("", AV40ImpLiqDetLegId)==0) )
         {
            AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegid( GXutil.trim( AV40ImpLiqDetLegId) );
            new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "setea id", "")) ;
         }
         else
         {
            AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegid( GXutil.trim( AV37ImpLiqDetCUIL) );
            new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "setea cuilid ", "")+AV37ImpLiqDetCUIL) ;
         }
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegfecingreso())) )
      {
         GXt_date6 = AV82predetIngFecha ;
         GXv_date7[0] = GXt_date6 ;
         new web.fecingpredetimpor(remoteHandle, context).execute( GXv_date7) ;
         importarlegajolsd.this.GXt_date6 = GXv_date7[0] ;
         AV82predetIngFecha = GXt_date6 ;
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegfecingreso( AV82predetIngFecha );
      }
      AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegcuil( AV37ImpLiqDetCUIL );
      new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "&importacion_legajo.MigrLegApellido ", "")+AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegapellido()) ;
      if ( (GXutil.strcmp("", AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegapellido())==0) )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "scrape", "")) ;
         /* Execute user subroutine: 'SCRAPE CUIL' */
         S131 ();
         if (returnInSub) return;
      }
      GXv_char1[0] = AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegmodtra() ;
      new web.defaultmigr(remoteHandle, context).execute( AV13CliCod, AV17EmpCod, httpContext.getMessage( "Relación laboral", ""), GXv_char1) ;
      AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegmodtra( GXv_char1[0] );
      if ( (GXutil.strcmp("", AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegclase())==0) )
      {
         if ( (GXutil.strcmp("", AV41ImpLiqDetLiqClase)==0) || ( GXutil.strcmp(AV41ImpLiqDetLiqClase, httpContext.getMessage( "M", "")) == 0 ) )
         {
            AV55MigrLegClase = httpContext.getMessage( "Mensual", "") ;
            AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegtipotarifa( "P" );
         }
         else
         {
            AV55MigrLegClase = httpContext.getMessage( "Quincenal", "") ;
            AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegtipotarifa( "H" );
         }
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegclase( AV55MigrLegClase );
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegclasedef( false );
         AV84que = httpContext.getMessage( "Frecuencia de pago", "") ;
         /* Execute user subroutine: 'SACAR WARNING DEFAULT' */
         S151 ();
         if (returnInSub) return;
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegfecnac())) )
      {
         GXt_date6 = GXutil.nullDate() ;
         GXv_date7[0] = GXt_date6 ;
         new web.fecnacpredetimpor(remoteHandle, context).execute( GXv_date7) ;
         importarlegajolsd.this.GXt_date6 = GXv_date7[0] ;
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegfecnac( GXt_date6 );
      }
      if ( GXutil.strcmp(GXutil.trim( AV81formaDePago), "1") == 0 )
      {
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegformapago( httpContext.getMessage( "EFECTIVO", "") );
      }
      else if ( GXutil.strcmp(GXutil.trim( AV81formaDePago), "2") == 0 )
      {
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegformapago( httpContext.getMessage( "CHEQUE", "") );
      }
      else
      {
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegformapago( httpContext.getMessage( "TRANSFERENCIA", "") );
      }
      AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegformapagodef( false );
      AV84que = httpContext.getMessage( "Forma de Pago", "") ;
      /* Execute user subroutine: 'SACAR WARNING DEFAULT' */
      S151 ();
      if (returnInSub) return;
   }

   public void S171( )
   {
      /* 'LOAD KEY' Routine */
      returnInSub = false ;
      GXv_int8[0] = AV56MigrLegNumero ;
      new web.getmigrlegporcuil(remoteHandle, context).execute( AV13CliCod, AV17EmpCod, AV37ImpLiqDetCUIL, GXv_int8) ;
      importarlegajolsd.this.AV56MigrLegNumero = GXv_int8[0] ;
      AV49importacion_legajo = (web.Sdtimportacion_legajo)new web.Sdtimportacion_legajo( remoteHandle, context);
      if ( (0==AV56MigrLegNumero) )
      {
         AV22existe = false ;
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Clicod( AV13CliCod );
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Empcod( AV17EmpCod );
         GXv_int8[0] = AV56MigrLegNumero ;
         new web.obtieneultimolegajomigracion(remoteHandle, context).execute( AV13CliCod, AV17EmpCod, GXv_int8) ;
         importarlegajolsd.this.AV56MigrLegNumero = GXv_int8[0] ;
         AV56MigrLegNumero = (int)(AV56MigrLegNumero+1) ;
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegnumero( AV56MigrLegNumero );
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "existe migrleg", "")) ;
         AV22existe = true ;
         AV49importacion_legajo.Load(AV13CliCod, AV17EmpCod, AV56MigrLegNumero);
         AV80anteriorFecha = AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegfecingreso() ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "load &importacion_legajo ", "")+GXutil.trim( GXutil.str( AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegnumero(), 8, 0))+httpContext.getMessage( " &importacion_legajo MigrLegId ", "")+AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegid()) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "&MigrLegNumero ", "")+GXutil.trim( GXutil.str( AV56MigrLegNumero, 8, 0))) ;
   }

   public void S181( )
   {
      /* 'SAVE' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "save &importacion_legajo.MigrLegId ", "")+AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegid()) ;
      if ( ! AV22existe )
      {
         AV49importacion_legajo.Save();
      }
      else
      {
         AV49importacion_legajo.Update();
      }
      if ( ! AV49importacion_legajo.Success() )
      {
         AV53Messages = AV49importacion_legajo.GetMessages() ;
         AV50IsOk = false ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "save 3", "")) ;
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "save 4", "")) ;
      }
   }

   public void S131( )
   {
      /* 'SCRAPE CUIL' Routine */
      returnInSub = false ;
      AV98sdt_AuxScrapeados.fromJSonString(httpContext.getMessage( "[{\"CUIL\": \"20275160548\", \"Apellido\": \"ROIJBERK\",  \"Nombre\": \"FEDERICO JONATHAN\"}, {\"CUIL\": \"20349455618\", \"Apellido\": \"** (APELLIDO)\", \"Nombre\": \"20349455618\"}, {\"CUIL\": \"23348769294\", \"Apellido\": \"PIQUE\",  \"Nombre\": \"ANA LAURA\"}, {\"CUIL\": \"20297760123\", \"Apellido\": \"FLANDES\",  \"Nombre\": \"RIQUELME JUAN IGNACIO\"}, {\"CUIL\": \"20320970432\", \"Apellido\": \"BUZZI\",  \"Nombre\": \"MAURO DAMIAN\"}, {\"CUIL\": \"20220867022\", \"Apellido\": \"ECHEVERRIA\",  \"Nombre\": \"RUBEN DANIEL\"}, {\"CUIL\": \"23269425954\", \"Apellido\": \"RODRIGUEZ\",  \"Nombre\": \"ELIZABET ANABELLA CELESTE\"}, {\"CUIL\": \"20461783911\", \"Apellido\": \"** (APELLIDO)\", \"Nombre\": \"20461783911\"}, {\"CUIL\": \"20350703595\", \"Apellido\": \"CARRIZO\",  \"Nombre\": \"SERGIO FABIAN\"}, {\"CUIL\": \"20403743314\", \"Apellido\": \"** (APELLIDO)\", \"Nombre\": \"20403743314\"}, {\"CUIL\": \"20306738101\", \"Apellido\": \"CHAMBON\",  \"Nombre\": \"EZEQUIEL JAVIER\"}, {\"CUIL\": \"20101402461\", \"Apellido\": \"MASTOY\",  \"Nombre\": \"RICARDO FRANCISCO\"}, {\"CUIL\": \"23412123859\", \"Apellido\": \"** (APELLIDO)\", \"Nombre\": \"23412123859\"}, {\"CUIL\": \"23293006989\", \"Apellido\": \"HARDOY\",  \"Nombre\": \"MAXIMILIANO IVAN\"}, {\"CUIL\": \"20439722178\", \"Apellido\": \"VIVEROS\",  \"Nombre\": \"CORNACCHINI LUCIANO NICOLAS\"}, {\"CUIL\": \"23162509179\", \"Apellido\": \"POBBIO\",  \"Nombre\": \"HORACIO HECTOR\"}, {\"CUIL\": \"23960447239\", \"Apellido\": \"** (APELLIDO)\", \"Nombre\": \"23960447239\"}, {\"CUIL\": \"20277089743\", \"Apellido\": \"** (APELLIDO)\", \"Nombre\": \"20277089743\"}, {\"CUIL\": \"20312608759\", \"Apellido\": \"VILLALBA\",  \"Nombre\": \"JOAQUIN ALBERTO\"}, {\"CUIL\": \"20245291311\", \"Apellido\": \"** (APELLIDO)\", \"Nombre\": \"20245291311\"}, {\"CUIL\": \"20446847830\", \"Apellido\": \"ZUNIGA\",  \"Nombre\": \"CLAUDIO NICOLAS\"}, {\"CUIL\": \"20468062934\", \"Apellido\": \"BUSTOS\",  \"Nombre\": \"DAVILA LAUTARO GASTON\"}, {\"CUIL\": \"20338745878\", \"Apellido\": \"RODRIGUEZ\",  \"Nombre\": \"FERNANDO EZEQUIEL\"}, {\"CUIL\": \"20428306105\", \"Apellido\": \"ALMADA\",  \"Nombre\": \"AGUSTIN INAKI\"}, {\"CUIL\": \"20175389939\", \"Apellido\": \"** (APELLIDO)\", \"Nombre\": \"20175389939\"}, {\"CUIL\": \"20296907635\", \"Apellido\": \"GONZALEZ\",  \"Nombre\": \"FABIO GASTON\"}, {\"CUIL\": \"20265715568\", \"Apellido\": \"** (APELLIDO)\", \"Nombre\": \"20265715568\"}, {\"CUIL\": \"20241198899\", \"Apellido\": \"RICARDO\",  \"Nombre\": \"OLAECHEA LEANDRO CRISTIAN\"}, {\"CUIL\": \"20448569919\", \"Apellido\": \"RIVERO\",  \"Nombre\": \"ISAIAS MIGUEL\"}, {\"CUIL\": \"23460936659\", \"Apellido\": \"TOBAR\",  \"Nombre\": \"LAGOS MAXIMO ALEJANDRO\"}, {\"CUIL\": \"20282451264\", \"Apellido\": \"RODRIGUEZ\",  \"Nombre\": \"JORGE LUIS\"}, {\"CUIL\": \"27291453401\", \"Apellido\": \"COCCONI\",  \"Nombre\": \"NOELIA MARINA\"}, {\"CUIL\": \"27378247530\", \"Apellido\": \"** (APELLIDO)\", \"Nombre\": \"27378247530\"}, {\"CUIL\": \"20126667753\", \"Apellido\": \"CONTRERAS\",  \"Nombre\": \"JUAN ANGEL\"}, {\"CUIL\": \"20359202084\", \"Apellido\": \"SOLAIMAN\",  \"Nombre\": \"LEONARDO DAVID\"}, {\"CUIL\": \"20327167856\", \"Apellido\": \"GUERRINO\",  \"Nombre\": \"LUCIANO ATILIO\"}, {\"CUIL\": \"20347469573\", \"Apellido\": \"GUZMAN\",  \"Nombre\": \"LUCAS SEBASTIAN\"}, {\"CUIL\": \"20464051091\", \"Apellido\": \"** (APELLIDO)\", \"Nombre\": \"20464051091\"}, {\"CUIL\": \"20279789726\", \"Apellido\": \"OJEDA\",  \"Nombre\": \"ROBERTO MARIO\"}, {\"CUIL\": \"20424304353\", \"Apellido\": \"PINEDO\",  \"Nombre\": \"DUCASSE ALEJO\"}, {\"CUIL\": \"20279754809\", \"Apellido\": \"ARGUELLO\",  \"Nombre\": \"ARIEL GUSTAVO\"}, {\"CUIL\": \"20260423550\", \"Apellido\": \"OJEDA\",  \"Nombre\": \"VICTOR HUGO\"}, {\"CUIL\": \"20322711280\", \"Apellido\": \"** (APELLIDO)\", \"Nombre\": \"20322711280\"}, {\"CUIL\": \"20340340478\", \"Apellido\": \"NAVARRETE\",  \"Nombre\": \"MARCOS DAVID\"}, {\"CUIL\": \"20293103853\", \"Apellido\": \"FRECHERO\",  \"Nombre\": \"ISLA GERMAN OSCAR\"}]", ""), null);
      AV99s = (short)(1) ;
      AV100encontro = false ;
      while ( AV99s <= AV98sdt_AuxScrapeados.size() )
      {
         if ( GXutil.strcmp(GXutil.trim( AV37ImpLiqDetCUIL), GXutil.trim( ((web.Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem)AV98sdt_AuxScrapeados.elementAt(-1+AV99s)).getgxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Cuil())) == 0 )
         {
            AV100encontro = true ;
            AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegapellido( GXutil.trim( ((web.Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem)AV98sdt_AuxScrapeados.elementAt(-1+AV99s)).getgxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Apellido()) );
            AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegnombre( GXutil.trim( ((web.Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem)AV98sdt_AuxScrapeados.elementAt(-1+AV99s)).getgxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Nombre()) );
            if (true) break;
         }
         AV99s = (short)(AV99s+1) ;
      }
      if ( ! AV100encontro )
      {
         if ( AV93scrapearCuil )
         {
            GXv_char1[0] = AV70nombreYApellido ;
            GXv_char9[0] = AV71scrapeError ;
            new web.scrapecuil(remoteHandle, context).execute( AV13CliCod, AV37ImpLiqDetCUIL, GXv_char1, GXv_char9) ;
            importarlegajolsd.this.AV70nombreYApellido = GXv_char1[0] ;
            importarlegajolsd.this.AV71scrapeError = GXv_char9[0] ;
            if ( ! (GXutil.strcmp("", AV71scrapeError)==0) || (GXutil.strcmp("", AV70nombreYApellido)==0) )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "scrapeerror ", "")+GXutil.trim( AV71scrapeError)) ;
               AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegapellido( httpContext.getMessage( "** (Apellido)", "") );
               AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegnombre( GXutil.trim( AV37ImpLiqDetCUIL) );
            }
            else
            {
               GXv_char9[0] = AV95MigrLegNombre ;
               GXv_char1[0] = AV96MigrLegApellido ;
               new web.desglosarnombreyapellido(remoteHandle, context).execute( AV70nombreYApellido, GXv_char9, GXv_char1) ;
               importarlegajolsd.this.AV95MigrLegNombre = GXv_char9[0] ;
               importarlegajolsd.this.AV96MigrLegApellido = GXv_char1[0] ;
               AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegnombre( "* "+GXutil.trim( AV95MigrLegNombre) );
               AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegapellido( GXutil.trim( AV96MigrLegApellido) );
            }
         }
      }
   }

   public void S151( )
   {
      /* 'SACAR WARNING DEFAULT' Routine */
      returnInSub = false ;
      GXt_char10 = AV90mensaje ;
      GXt_char11 = AV90mensaje ;
      GXv_char9[0] = GXt_char11 ;
      new web.defaultmigr(remoteHandle, context).execute( AV13CliCod, AV17EmpCod, AV84que, GXv_char9) ;
      importarlegajolsd.this.GXt_char11 = GXv_char9[0] ;
      GXv_char1[0] = GXt_char10 ;
      new web.mensajemigrseingresodefault(remoteHandle, context).execute( AV13CliCod, AV84que, GXt_char11, GXv_char1) ;
      importarlegajolsd.this.GXt_char10 = GXv_char1[0] ;
      AV90mensaje = GXt_char10 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "warning id ", "")+AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegid()) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "antes &importacion_legajo.MigrLegWarnings ", "")+GXutil.trim( AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegwarnings())) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "tiporeg ", "")+GXutil.trim( AV66tipoRegistro)+httpContext.getMessage( " reemplaza &mensaje ", "")+GXutil.trim( AV90mensaje)) ;
      AV90mensaje += httpContext.getMessage( " <BR>", "") ;
      AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegwarnings( GXutil.strReplace( AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegwarnings(), AV90mensaje, "") );
      new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "despues &importacion_legajo.MigrLegWarnings ", "")+GXutil.trim( AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegwarnings())) ;
   }

   protected void cleanup( )
   {
      this.aP4[0] = importarlegajolsd.this.AV19errores;
      this.aP5[0] = importarlegajolsd.this.AV12altas;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19errores = new GXSimpleCollection<String>(String.class, "internal", "");
      AV104Pgmname = "" ;
      AV10ahora = GXutil.resetTime( GXutil.nullDate() );
      scmdbuf = "" ;
      P027H2_A704ImpLiqLSDSec = new short[1] ;
      P027H2_A88ImpLiqSec = new short[1] ;
      P027H2_A1EmpCod = new short[1] ;
      P027H2_A3CliCod = new int[1] ;
      P027H2_A706ImpLiqLSDFileName = new String[] {""} ;
      P027H2_A707ImpLiqLSDFileType = new String[] {""} ;
      P027H2_A705ImpLiqLSDFile = new String[] {""} ;
      P027H2_A708ImpLiqLSDFileNameAndType = new String[] {""} ;
      A706ImpLiqLSDFileName = "" ;
      A707ImpLiqLSDFileType = "" ;
      A705ImpLiqLSDFile = "" ;
      A708ImpLiqLSDFileNameAndType = "" ;
      AV25File = new com.genexus.util.GXFile();
      AV68varcharcollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26fileLine = "" ;
      AV20errorFormato = "" ;
      AV66tipoRegistro = "" ;
      AV41ImpLiqDetLiqClase = "" ;
      AV76ImpLiqDetPer = "" ;
      AV77fecha = GXutil.nullDate() ;
      AV37ImpLiqDetCUIL = "" ;
      AV40ImpLiqDetLegId = "" ;
      AV33ImpLiqDetCBU = "" ;
      AV81formaDePago = "" ;
      AV24fechaPago = "" ;
      AV44ImpLiqDetSigno = "" ;
      AV39ImpLiqDetImp = "" ;
      AV83ZonCod = "" ;
      AV86ZonDescrip = "" ;
      AV87MprCod = "" ;
      AV85MprDescrip = "" ;
      AV89LSD4Conyuge_14_1 = "" ;
      AV94LSD4MarcaCCT_17_1 = "" ;
      AV101MigrLegObraSocial = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV92auxErrores = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_svchar3 = new GXSimpleCollection[1] ;
      AV91auxWarnings = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_svchar4 = new GXSimpleCollection[1] ;
      AV9ultiError = "" ;
      AV18error = "" ;
      AV49importacion_legajo = new web.Sdtimportacion_legajo(remoteHandle);
      AV82predetIngFecha = GXutil.nullDate() ;
      AV80anteriorFecha = GXutil.nullDate() ;
      AV84que = "" ;
      GXv_Sdtimportacion_legajo5 = new web.Sdtimportacion_legajo[1] ;
      AV55MigrLegClase = "" ;
      GXt_date6 = GXutil.nullDate() ;
      GXv_date7 = new java.util.Date[1] ;
      GXv_int8 = new int[1] ;
      AV53Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      AV98sdt_AuxScrapeados = new GXBaseCollection<web.Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem>(web.Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem.class, "sdt_AuxScrapeadosItem", "PayDay", remoteHandle);
      AV70nombreYApellido = "" ;
      AV71scrapeError = "" ;
      AV95MigrLegNombre = "" ;
      AV96MigrLegApellido = "" ;
      AV90mensaje = "" ;
      GXt_char10 = "" ;
      GXt_char11 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char1 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importarlegajolsd__default(),
         new Object[] {
             new Object[] {
            P027H2_A704ImpLiqLSDSec, P027H2_A88ImpLiqSec, P027H2_A1EmpCod, P027H2_A3CliCod, P027H2_A706ImpLiqLSDFileName, P027H2_A707ImpLiqLSDFileType, P027H2_A705ImpLiqLSDFile, P027H2_A708ImpLiqLSDFileNameAndType
            }
         }
      );
      AV104Pgmname = "ImportarLegajoLSD" ;
      /* GeneXus formulas. */
      AV104Pgmname = "ImportarLegajoLSD" ;
      Gx_err = (short)(0) ;
   }

   private byte AV105GXLvl15 ;
   private byte AV79LiqPerMes ;
   private short AV17EmpCod ;
   private short AV48ImpLiqSec ;
   private short AV47ImpLiqLSDSec ;
   private short AV12altas ;
   private short AV69vez ;
   private short A704ImpLiqLSDSec ;
   private short A88ImpLiqSec ;
   private short A1EmpCod ;
   private short AV23f ;
   private short AV78LiqPerAno ;
   private short AV16e ;
   private short AV99s ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int A3CliCod ;
   private int AV106GXV1 ;
   private int AV56MigrLegNumero ;
   private int GXv_int8[] ;
   private String AV104Pgmname ;
   private String scmdbuf ;
   private String A707ImpLiqLSDFileType ;
   private String AV26fileLine ;
   private String AV66tipoRegistro ;
   private String AV41ImpLiqDetLiqClase ;
   private String AV76ImpLiqDetPer ;
   private String AV37ImpLiqDetCUIL ;
   private String AV40ImpLiqDetLegId ;
   private String AV81formaDePago ;
   private String AV24fechaPago ;
   private String AV44ImpLiqDetSigno ;
   private String AV39ImpLiqDetImp ;
   private String AV83ZonCod ;
   private String AV87MprCod ;
   private String AV89LSD4Conyuge_14_1 ;
   private String AV94LSD4MarcaCCT_17_1 ;
   private String AV84que ;
   private String GXt_char10 ;
   private String GXt_char11 ;
   private String GXv_char9[] ;
   private String GXv_char1[] ;
   private java.util.Date AV10ahora ;
   private java.util.Date AV77fecha ;
   private java.util.Date AV82predetIngFecha ;
   private java.util.Date AV80anteriorFecha ;
   private java.util.Date GXt_date6 ;
   private java.util.Date GXv_date7[] ;
   private boolean AV63seguir ;
   private boolean AV50IsOk ;
   private boolean AV93scrapearCuil ;
   private boolean AV14completo ;
   private boolean AV11algunoCompleto ;
   private boolean AV59registro1Hay ;
   private boolean AV60registro2Hay ;
   private boolean AV61registro3Hay ;
   private boolean AV62registro4Hay ;
   private boolean returnInSub ;
   private boolean AV65tipoDeRegistroInvalido ;
   private boolean AV21esNumero ;
   private boolean GXv_boolean2[] ;
   private boolean AV22existe ;
   private boolean Cond_result ;
   private boolean AV8algunaLineaHay ;
   private boolean AV100encontro ;
   private String A705ImpLiqLSDFile ;
   private String A706ImpLiqLSDFileName ;
   private String A708ImpLiqLSDFileNameAndType ;
   private String AV20errorFormato ;
   private String AV33ImpLiqDetCBU ;
   private String AV86ZonDescrip ;
   private String AV85MprDescrip ;
   private String AV101MigrLegObraSocial ;
   private String AV9ultiError ;
   private String AV18error ;
   private String AV55MigrLegClase ;
   private String AV70nombreYApellido ;
   private String AV71scrapeError ;
   private String AV95MigrLegNombre ;
   private String AV96MigrLegApellido ;
   private String AV90mensaje ;
   private com.genexus.util.GXFile AV25File ;
   private web.Sdtimportacion_legajo AV49importacion_legajo ;
   private short[] aP5 ;
   private GXSimpleCollection<String>[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P027H2_A704ImpLiqLSDSec ;
   private short[] P027H2_A88ImpLiqSec ;
   private short[] P027H2_A1EmpCod ;
   private int[] P027H2_A3CliCod ;
   private String[] P027H2_A706ImpLiqLSDFileName ;
   private String[] P027H2_A707ImpLiqLSDFileType ;
   private String[] P027H2_A705ImpLiqLSDFile ;
   private String[] P027H2_A708ImpLiqLSDFileNameAndType ;
   private GXSimpleCollection<String> AV68varcharcollection ;
   private GXSimpleCollection<String> AV19errores ;
   private GXSimpleCollection<String> AV92auxErrores ;
   private GXSimpleCollection<String> GXv_objcol_svchar3[] ;
   private GXSimpleCollection<String> AV91auxWarnings ;
   private GXSimpleCollection<String> GXv_objcol_svchar4[] ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV53Messages ;
   private GXBaseCollection<web.Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem> AV98sdt_AuxScrapeados ;
   private web.Sdtimportacion_legajo GXv_Sdtimportacion_legajo5[] ;
}

final  class importarlegajolsd__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P027H2", "SELECT ImpLiqLSDSec, ImpLiqSec, EmpCod, CliCod, ImpLiqLSDFileName, ImpLiqLSDFileType, ImpLiqLSDFile, ImpLiqLSDFileNameAndType FROM importacion_liquidacion_lsd WHERE CliCod = ? and EmpCod = ? and ImpLiqSec = ? and ImpLiqLSDSec = ? ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqLSDSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getBLOBFile(7, rslt.getString(6, 20), rslt.getVarchar(5));
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
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
      }
   }

}

