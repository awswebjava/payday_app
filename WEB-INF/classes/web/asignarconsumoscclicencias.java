package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class asignarconsumoscclicencias extends GXProcedure
{
   public asignarconsumoscclicencias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( asignarconsumoscclicencias.class ), "" );
   }

   public asignarconsumoscclicencias( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        short aP4 ,
                        String aP5 ,
                        int aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             short aP4 ,
                             String aP5 ,
                             int aP6 )
   {
      asignarconsumoscclicencias.this.AV12CliCod = aP0;
      asignarconsumoscclicencias.this.AV11EmpCod = aP1;
      asignarconsumoscclicencias.this.AV10LegNumero = aP2;
      asignarconsumoscclicencias.this.AV17iniFecha = aP3;
      asignarconsumoscclicencias.this.AV13cantAAsignar = aP4;
      asignarconsumoscclicencias.this.AV36lic_orig_consumos = aP5;
      asignarconsumoscclicencias.this.AV44egresoLiqNro = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9LegCuenLicTpo = "Vacaciones" ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV47Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV12CliCod, 6, 0))+httpContext.getMessage( " empcod ", "")+GXutil.trim( GXutil.str( AV11EmpCod, 4, 0))+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( GXutil.str( AV10LegNumero, 8, 0))+httpContext.getMessage( " &iniFecha ", "")+GXutil.trim( localUtil.dtoc( AV17iniFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &LegCuenLicTpo ", "")+GXutil.trim( AV9LegCuenLicTpo)) ;
      AV35original_cantAAsignar = AV13cantAAsignar ;
      while ( true )
      {
         gxexitloop = false ;
         if ( gxexitloop )
         {
            break;
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV47Pgmname, httpContext.getMessage( "&LegCuLConsAnio ", "")+GXutil.trim( GXutil.str( AV14LegCuLConsAnio, 4, 0))+httpContext.getMessage( " &cantAAsignar ", "")+GXutil.trim( GXutil.str( AV13cantAAsignar, 4, 0))) ;
         AV48GXLvl9 = (byte)(0) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              Short.valueOf(AV14LegCuLConsAnio) ,
                                              A2244LegCuenLicPerIni ,
                                              AV17iniFecha ,
                                              A2245LegCuenLicPerFin ,
                                              Short.valueOf(A2266LegCuenAnio) ,
                                              Integer.valueOf(AV12CliCod) ,
                                              Short.valueOf(AV11EmpCod) ,
                                              Integer.valueOf(AV10LegNumero) ,
                                              AV9LegCuenLicTpo ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Integer.valueOf(A6LegNumero) ,
                                              A2243LegCuenLicTpo } ,
                                              new int[]{
                                              TypeConstants.SHORT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                              TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING
                                              }
         });
         /* Using cursor P02BV2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV10LegNumero), AV9LegCuenLicTpo, AV17iniFecha, AV17iniFecha, Short.valueOf(AV14LegCuLConsAnio)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A2266LegCuenAnio = P02BV2_A2266LegCuenAnio[0] ;
            A2245LegCuenLicPerFin = P02BV2_A2245LegCuenLicPerFin[0] ;
            A2244LegCuenLicPerIni = P02BV2_A2244LegCuenLicPerIni[0] ;
            A2243LegCuenLicTpo = P02BV2_A2243LegCuenLicTpo[0] ;
            A6LegNumero = P02BV2_A6LegNumero[0] ;
            A1EmpCod = P02BV2_A1EmpCod[0] ;
            A3CliCod = P02BV2_A3CliCod[0] ;
            A2322LegCuLRecalc = P02BV2_A2322LegCuLRecalc[0] ;
            A2248LegCuenDiasGoz = P02BV2_A2248LegCuenDiasGoz[0] ;
            A2247LegCuenDiasCorres = P02BV2_A2247LegCuenDiasCorres[0] ;
            AV48GXLvl9 = (byte)(1) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV47Pgmname, httpContext.getMessage( "entra LegNumero ", "")+GXutil.trim( GXutil.str( A6LegNumero, 8, 0))+httpContext.getMessage( " LegCuenAnio ", "")+GXutil.trim( GXutil.str( A2266LegCuenAnio, 4, 0))) ;
            if ( ! (0==AV13cantAAsignar) && ( A2322LegCuLRecalc ) )
            {
               A2248LegCuenDiasGoz = (short)(A2248LegCuenDiasGoz+AV13cantAAsignar) ;
               GXv_boolean1[0] = AV38corrigio ;
               GXv_int2[0] = AV40LegCuenDiasCorres ;
               new web.newliccc_aprobacion(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, A2243LegCuenLicTpo, A2266LegCuenAnio, AV17iniFecha, AV13cantAAsignar, AV36lic_orig_consumos, AV44egresoLiqNro, GXv_boolean1, GXv_int2) ;
               asignarconsumoscclicencias.this.AV38corrigio = GXv_boolean1[0] ;
               asignarconsumoscclicencias.this.AV40LegCuenDiasCorres = GXv_int2[0] ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV47Pgmname, httpContext.getMessage( "&corrigio ", "")+GXutil.trim( GXutil.booltostr( AV38corrigio))) ;
               if ( AV38corrigio )
               {
                  A2248LegCuenDiasGoz = AV40LegCuenDiasCorres ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV47Pgmname, httpContext.getMessage( "actualiza a LegCuenDiasGoz ", "")+GXutil.trim( GXutil.str( A2248LegCuenDiasGoz, 4, 0))+httpContext.getMessage( " LegCuenDiasCorres ", "")+GXutil.trim( GXutil.str( A2247LegCuenDiasCorres, 4, 0))) ;
               }
               new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV47Pgmname, httpContext.getMessage( "suma", "")) ;
            }
            AV14LegCuLConsAnio = A2266LegCuenAnio ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            /* Using cursor P02BV3 */
            pr_default.execute(1, new Object[] {Short.valueOf(A2248LegCuenDiasGoz), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licencias");
            if (true) break;
            /* Using cursor P02BV4 */
            pr_default.execute(2, new Object[] {Short.valueOf(A2248LegCuenDiasGoz), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licencias");
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV48GXLvl9 == 0 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV47Pgmname, httpContext.getMessage( "none", "")) ;
            AV30nones = (short)(AV30nones+1) ;
         }
         if ( ! (0==AV14LegCuLConsAnio) || ( AV30nones == 3 ) )
         {
            if (true) break;
         }
         else
         {
            if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV17iniFecha)) )
            {
               if (true) break;
            }
            else
            {
               AV14LegCuLConsAnio = (short)(GXutil.year( AV17iniFecha)) ;
            }
         }
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV47Pgmname, httpContext.getMessage( "cant ", "")+GXutil.trim( GXutil.str( AV13cantAAsignar, 4, 0))+httpContext.getMessage( " &LegCuLConsAnio ", "")+GXutil.trim( GXutil.str( AV14LegCuLConsAnio, 4, 0))) ;
      GXv_int3[0] = AV22EmpPerVacDes ;
      GXv_int4[0] = AV23EmpPerVacHas ;
      GXv_decimal5[0] = AV20EmpFracVacAnt ;
      new web.getemppervac(remoteHandle, context).execute( AV12CliCod, AV11EmpCod, GXv_int3, GXv_int4, GXv_decimal5) ;
      asignarconsumoscclicencias.this.AV22EmpPerVacDes = GXv_int3[0] ;
      asignarconsumoscclicencias.this.AV23EmpPerVacHas = GXv_int4[0] ;
      asignarconsumoscclicencias.this.AV20EmpFracVacAnt = GXv_decimal5[0] ;
      GXv_int6[0] = AV29EmpVacDisMax ;
      new web.getempvacmax(remoteHandle, context).execute( AV12CliCod, AV11EmpCod, GXv_int6) ;
      asignarconsumoscclicencias.this.AV29EmpVacDisMax = GXv_int6[0] ;
      AV18LegCuLTotCons = 0 ;
      AV19LegCuLTotCorr = 0 ;
      AV49GXLvl61 = (byte)(0) ;
      /* Using cursor P02BV5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV10LegNumero), AV9LegCuenLicTpo});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A2243LegCuenLicTpo = P02BV5_A2243LegCuenLicTpo[0] ;
         A6LegNumero = P02BV5_A6LegNumero[0] ;
         A1EmpCod = P02BV5_A1EmpCod[0] ;
         A3CliCod = P02BV5_A3CliCod[0] ;
         A2266LegCuenAnio = P02BV5_A2266LegCuenAnio[0] ;
         A2321LegCuLIncluir = P02BV5_A2321LegCuLIncluir[0] ;
         A2248LegCuenDiasGoz = P02BV5_A2248LegCuenDiasGoz[0] ;
         A2247LegCuenDiasCorres = P02BV5_A2247LegCuenDiasCorres[0] ;
         A2315LegCuLActVen = P02BV5_A2315LegCuLActVen[0] ;
         A2322LegCuLRecalc = P02BV5_A2322LegCuLRecalc[0] ;
         A2304LegCuLiPVen = P02BV5_A2304LegCuLiPVen[0] ;
         A2313LegCuLTotCons = P02BV5_A2313LegCuLTotCons[0] ;
         A2314LegCuLTotCorr = P02BV5_A2314LegCuLTotCorr[0] ;
         A2302LegCuLiPCur = P02BV5_A2302LegCuLiPCur[0] ;
         A2305LegCuLiPSaldo = P02BV5_A2305LegCuLiPSaldo[0] ;
         A2303LegCuLiPAnt = P02BV5_A2303LegCuLiPAnt[0] ;
         A2329LegCuLLogDis = P02BV5_A2329LegCuLLogDis[0] ;
         AV49GXLvl61 = (byte)(1) ;
         AV31LegCuenDiasGoz = (short)(AV31LegCuenDiasGoz+A2248LegCuenDiasGoz) ;
         AV19LegCuLTotCorr = (int)(AV19LegCuLTotCorr+A2247LegCuenDiasCorres) ;
         AV8LegCuLConsCnt = (short)(0) ;
         AV28actual_LegCuLConsCnt = (short)(0) ;
         AV42otrosAnios_LegCuLConsCnt = (short)(0) ;
         /* Using cursor P02BV6 */
         pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio)});
         while ( (pr_default.getStatus(4) != 101) )
         {
            A2310LegCuLConsAnio = P02BV6_A2310LegCuLConsAnio[0] ;
            A2312LegCuLConsCnt = P02BV6_A2312LegCuLConsCnt[0] ;
            A2311LegCuLConsSec = P02BV6_A2311LegCuLConsSec[0] ;
            if ( A2310LegCuLConsAnio == A2266LegCuenAnio )
            {
               AV8LegCuLConsCnt = (short)(AV8LegCuLConsCnt+A2312LegCuLConsCnt) ;
            }
            else
            {
               AV42otrosAnios_LegCuLConsCnt = (short)(AV42otrosAnios_LegCuLConsCnt+A2312LegCuLConsCnt) ;
            }
            AV18LegCuLTotCons = (int)(AV18LegCuLTotCons+A2312LegCuLConsCnt) ;
            AV28actual_LegCuLConsCnt = (short)(AV28actual_LegCuLConsCnt+A2312LegCuLConsCnt) ;
            pr_default.readNext(4);
         }
         pr_default.close(4);
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV47Pgmname, httpContext.getMessage( "LegCuenAnio ", "")+GXutil.trim( GXutil.str( A2266LegCuenAnio, 4, 0))+httpContext.getMessage( " LegCuenAnio ", "")+GXutil.trim( GXutil.str( A2266LegCuenAnio, 4, 0))+httpContext.getMessage( " &LegCuLConsCnt ", "")+GXutil.trim( GXutil.str( AV8LegCuLConsCnt, 4, 0))+httpContext.getMessage( " LegCuenDiasGoz ", "")+GXutil.trim( GXutil.str( A2248LegCuenDiasGoz, 4, 0))) ;
         if ( A2248LegCuenDiasGoz > A2247LegCuenDiasCorres )
         {
            AV25otorgados = A2248LegCuenDiasGoz ;
         }
         else
         {
            AV25otorgados = A2247LegCuenDiasCorres ;
         }
         AV15auxCantAAsignar = AV13cantAAsignar ;
         AV16disponibles = (short)(AV25otorgados-AV28actual_LegCuLConsCnt) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV47Pgmname, httpContext.getMessage( "&otorgados ", "")+GXutil.trim( GXutil.str( AV25otorgados, 4, 0))+httpContext.getMessage( " &actual_LegCuLConsCnt ", "")+GXutil.trim( GXutil.str( AV28actual_LegCuLConsCnt, 4, 0))+httpContext.getMessage( " &disponibles ", "")+GXutil.trim( GXutil.str( AV16disponibles, 4, 0))) ;
         if ( A2266LegCuenAnio != AV14LegCuLConsAnio )
         {
            AV16disponibles = (short)(AV16disponibles-A2315LegCuLActVen) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV47Pgmname, httpContext.getMessage( "disponible resta vencidos ", "")+GXutil.trim( GXutil.str( AV16disponibles, 4, 0))) ;
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV47Pgmname, httpContext.getMessage( "cofrigigio ", "")+GXutil.trim( GXutil.booltostr( AV38corrigio))) ;
         if ( ! AV38corrigio || ( A2266LegCuenAnio < AV14LegCuLConsAnio ) )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV47Pgmname, httpContext.getMessage( "es mayor?", "")) ;
            if ( AV15auxCantAAsignar > AV16disponibles )
            {
               AV15auxCantAAsignar = AV16disponibles ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV47Pgmname, httpContext.getMessage( " resto disponbiles ", "")+GXutil.trim( GXutil.str( AV15auxCantAAsignar, 4, 0))) ;
            }
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV47Pgmname, httpContext.getMessage( " &auxCantAAsignar ", "")+GXutil.trim( GXutil.str( AV15auxCantAAsignar, 4, 0))) ;
         if ( ! (0==AV35original_cantAAsignar) && ( AV15auxCantAAsignar > 0 ) && ( A2266LegCuenAnio <= AV14LegCuLConsAnio ) )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV47Pgmname, httpContext.getMessage( "va a new", "")) ;
            GXv_int2[0] = AV41corrigiocant ;
            new web.newlegcclicconsumos(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, A2243LegCuenLicTpo, A2266LegCuenAnio, AV14LegCuLConsAnio, AV15auxCantAAsignar, AV36lic_orig_consumos, AV44egresoLiqNro, GXv_int2) ;
            asignarconsumoscclicencias.this.AV41corrigiocant = GXv_int2[0] ;
            AV8LegCuLConsCnt = (short)(AV8LegCuLConsCnt-AV41corrigiocant) ;
            AV18LegCuLTotCons = (int)(AV18LegCuLTotCons-AV41corrigiocant) ;
            AV28actual_LegCuLConsCnt = (short)(AV28actual_LegCuLConsCnt-AV41corrigiocant) ;
         }
         AV13cantAAsignar = (short)(AV13cantAAsignar-AV15auxCantAAsignar) ;
         AV18LegCuLTotCons = (int)(AV18LegCuLTotCons+AV15auxCantAAsignar) ;
         if ( A2322LegCuLRecalc )
         {
            if ( A2266LegCuenAnio == AV14LegCuLConsAnio )
            {
               if ( AV20EmpFracVacAnt.doubleValue() >= 1 )
               {
                  A2315LegCuLActVen = (short)(0) ;
               }
               else
               {
                  if ( ( AV8LegCuLConsCnt + AV15auxCantAAsignar ) < A2247LegCuenDiasCorres )
                  {
                     AV21disponiblesPorUnaje = DecimalUtil.doubleToDec(1).subtract(AV20EmpFracVacAnt) ;
                     A2315LegCuLActVen = (short)(DecimalUtil.decToDouble(GXutil.roundDecimal( DecimalUtil.doubleToDec((A2247LegCuenDiasCorres-(AV8LegCuLConsCnt+AV15auxCantAAsignar))).multiply(AV21disponiblesPorUnaje), 0))) ;
                  }
               }
            }
            A2304LegCuLiPVen = AV24LegCuLiPVen ;
         }
         AV24LegCuLiPVen = (short)(AV24LegCuLiPVen+A2315LegCuLActVen) ;
         if ( A2322LegCuLRecalc )
         {
            A2313LegCuLTotCons = AV18LegCuLTotCons ;
            A2314LegCuLTotCorr = AV19LegCuLTotCorr ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV47Pgmname, httpContext.getMessage( "pendientes actuales &otorgados ", "")+GXutil.trim( GXutil.str( AV25otorgados, 4, 0))+httpContext.getMessage( " &LegCuLConsCnt ", "")+GXutil.trim( GXutil.str( AV8LegCuLConsCnt, 4, 0))+httpContext.getMessage( " &original_cantAAsignar ", "")+GXutil.trim( GXutil.str( AV15auxCantAAsignar, 4, 0))) ;
            A2302LegCuLiPCur = (short)(AV25otorgados-AV8LegCuLConsCnt) ;
            if ( ( A2266LegCuenAnio == AV14LegCuLConsAnio ) && ! AV38corrigio )
            {
               A2302LegCuLiPCur = (short)(A2302LegCuLiPCur-AV35original_cantAAsignar) ;
            }
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV47Pgmname, httpContext.getMessage( "&LegCuLTotCons ", "")+GXutil.trim( GXutil.str( AV18LegCuLTotCons, 8, 0))+httpContext.getMessage( " &LegCuLTotCorr ", "")+GXutil.trim( GXutil.str( AV19LegCuLTotCorr, 8, 0))) ;
         if ( A2322LegCuLRecalc )
         {
            AV26LegCuLiPSaldo = A2247LegCuenDiasCorres ;
            AV39LegCuLLogDis = httpContext.getMessage( "inicializa \"Total disponible\" con ", "") + GXutil.trim( GXutil.str( AV26LegCuLiPSaldo, 4, 0)) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV47Pgmname, httpContext.getMessage( "inicializa \"Total disponible\" con ", "")+GXutil.trim( GXutil.str( AV26LegCuLiPSaldo, 4, 0))) ;
            if ( ! (0==A2248LegCuenDiasGoz) )
            {
               AV26LegCuLiPSaldo = (short)(AV26LegCuLiPSaldo-A2248LegCuenDiasGoz) ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV47Pgmname, httpContext.getMessage( ". Resta ", "")+GXutil.trim( GXutil.str( A2248LegCuenDiasGoz, 4, 0))+httpContext.getMessage( " de los días aprobados.", "")) ;
               AV39LegCuLLogDis += httpContext.getMessage( ". Resta ", "") + GXutil.trim( GXutil.str( A2248LegCuenDiasGoz, 4, 0)) + httpContext.getMessage( " de los días aprobados.", "") ;
            }
            if ( ! (0==AV33anterior_LegCuLiPSaldo) )
            {
               AV26LegCuLiPSaldo = (short)(AV26LegCuLiPSaldo+AV33anterior_LegCuLiPSaldo) ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV47Pgmname, httpContext.getMessage( ". Suma el disponible del año anterior ", "")+GXutil.trim( GXutil.str( AV33anterior_LegCuLiPSaldo, 4, 0))+httpContext.getMessage( " de los días aprobados.", "")) ;
               AV39LegCuLLogDis += httpContext.getMessage( ". Suma el disponible del año anterior ", "") + GXutil.trim( GXutil.str( AV33anterior_LegCuLiPSaldo, 4, 0)) + httpContext.getMessage( " de los días aprobados.", "") ;
            }
            AV43hoy = GXutil.serverDate( context, remoteHandle, pr_default) ;
            if ( ( A2266LegCuenAnio < GXutil.year( AV43hoy) ) && ( A2315LegCuLActVen > 0 ) )
            {
               AV26LegCuLiPSaldo = (short)(AV26LegCuLiPSaldo-A2315LegCuLActVen) ;
               AV39LegCuLLogDis += httpContext.getMessage( ". Resta ", "") + GXutil.trim( GXutil.str( A2315LegCuLActVen, 4, 0)) + httpContext.getMessage( " días de pendientes a vencer", "") ;
            }
            if ( ! (0==AV42otrosAnios_LegCuLConsCnt) )
            {
               AV26LegCuLiPSaldo = (short)(AV26LegCuLiPSaldo-AV42otrosAnios_LegCuLConsCnt) ;
               AV39LegCuLLogDis += httpContext.getMessage( ". Resta ", "") + GXutil.trim( GXutil.str( AV42otrosAnios_LegCuLConsCnt, 4, 0)) + httpContext.getMessage( " días de consumos de otros periodos", "") ;
            }
            AV34anterior_LegCuLActVen = A2315LegCuLActVen ;
            if ( ( AV29EmpVacDisMax > 0 ) && ( AV29EmpVacDisMax < AV26LegCuLiPSaldo ) )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV47Pgmname, httpContext.getMessage( ". Por ser la cantidad ", "")+GXutil.trim( GXutil.str( AV26LegCuLiPSaldo, 4, 0))+httpContext.getMessage( " mayor al tope ", "")+GXutil.trim( GXutil.str( AV29EmpVacDisMax, 6, 0))+httpContext.getMessage( " establece cantidad igual al tope", "")) ;
               AV39LegCuLLogDis += httpContext.getMessage( ". Por ser la cantidad ", "") + GXutil.trim( GXutil.str( AV26LegCuLiPSaldo, 4, 0)) + httpContext.getMessage( " mayor al tope ", "") + GXutil.trim( GXutil.str( AV29EmpVacDisMax, 6, 0)) + httpContext.getMessage( " establece cantidad igual al tope", "") ;
               AV26LegCuLiPSaldo = (short)(AV29EmpVacDisMax) ;
            }
            else
            {
               if ( AV26LegCuLiPSaldo < 0 )
               {
                  AV26LegCuLiPSaldo = (short)(0) ;
                  AV39LegCuLLogDis += httpContext.getMessage( ". Establece valor en cero por quedar en negativo", "") ;
               }
            }
            A2305LegCuLiPSaldo = AV26LegCuLiPSaldo ;
            A2303LegCuLiPAnt = AV27LegCuLiPCur ;
            A2329LegCuLLogDis = AV39LegCuLLogDis ;
         }
         AV33anterior_LegCuLiPSaldo = A2305LegCuLiPSaldo ;
         AV27LegCuLiPCur = (short)(AV27LegCuLiPCur+A2302LegCuLiPCur) ;
         /* Using cursor P02BV7 */
         pr_default.execute(5, new Object[] {Short.valueOf(A2315LegCuLActVen), Short.valueOf(A2304LegCuLiPVen), Integer.valueOf(A2313LegCuLTotCons), Integer.valueOf(A2314LegCuLTotCorr), Short.valueOf(A2302LegCuLiPCur), Short.valueOf(A2305LegCuLiPSaldo), Short.valueOf(A2303LegCuLiPAnt), A2329LegCuLLogDis, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licencias");
         pr_default.readNext(3);
      }
      pr_default.close(3);
      if ( AV49GXLvl61 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV47Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9LegCuenLicTpo = "" ;
      AV47Pgmname = "" ;
      scmdbuf = "" ;
      A2244LegCuenLicPerIni = GXutil.nullDate() ;
      A2245LegCuenLicPerFin = GXutil.nullDate() ;
      A2243LegCuenLicTpo = "" ;
      P02BV2_A2266LegCuenAnio = new short[1] ;
      P02BV2_A2245LegCuenLicPerFin = new java.util.Date[] {GXutil.nullDate()} ;
      P02BV2_A2244LegCuenLicPerIni = new java.util.Date[] {GXutil.nullDate()} ;
      P02BV2_A2243LegCuenLicTpo = new String[] {""} ;
      P02BV2_A6LegNumero = new int[1] ;
      P02BV2_A1EmpCod = new short[1] ;
      P02BV2_A3CliCod = new int[1] ;
      P02BV2_A2322LegCuLRecalc = new boolean[] {false} ;
      P02BV2_A2248LegCuenDiasGoz = new short[1] ;
      P02BV2_A2247LegCuenDiasCorres = new short[1] ;
      GXv_boolean1 = new boolean[1] ;
      GXv_int3 = new byte[1] ;
      GXv_int4 = new byte[1] ;
      AV20EmpFracVacAnt = DecimalUtil.ZERO ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      GXv_int6 = new int[1] ;
      P02BV5_A2243LegCuenLicTpo = new String[] {""} ;
      P02BV5_A6LegNumero = new int[1] ;
      P02BV5_A1EmpCod = new short[1] ;
      P02BV5_A3CliCod = new int[1] ;
      P02BV5_A2266LegCuenAnio = new short[1] ;
      P02BV5_A2321LegCuLIncluir = new boolean[] {false} ;
      P02BV5_A2248LegCuenDiasGoz = new short[1] ;
      P02BV5_A2247LegCuenDiasCorres = new short[1] ;
      P02BV5_A2315LegCuLActVen = new short[1] ;
      P02BV5_A2322LegCuLRecalc = new boolean[] {false} ;
      P02BV5_A2304LegCuLiPVen = new short[1] ;
      P02BV5_A2313LegCuLTotCons = new int[1] ;
      P02BV5_A2314LegCuLTotCorr = new int[1] ;
      P02BV5_A2302LegCuLiPCur = new short[1] ;
      P02BV5_A2305LegCuLiPSaldo = new short[1] ;
      P02BV5_A2303LegCuLiPAnt = new short[1] ;
      P02BV5_A2329LegCuLLogDis = new String[] {""} ;
      A2329LegCuLLogDis = "" ;
      P02BV6_A3CliCod = new int[1] ;
      P02BV6_A1EmpCod = new short[1] ;
      P02BV6_A6LegNumero = new int[1] ;
      P02BV6_A2243LegCuenLicTpo = new String[] {""} ;
      P02BV6_A2266LegCuenAnio = new short[1] ;
      P02BV6_A2310LegCuLConsAnio = new short[1] ;
      P02BV6_A2312LegCuLConsCnt = new short[1] ;
      P02BV6_A2311LegCuLConsSec = new short[1] ;
      GXv_int2 = new short[1] ;
      AV21disponiblesPorUnaje = DecimalUtil.ZERO ;
      AV39LegCuLLogDis = "" ;
      AV43hoy = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.asignarconsumoscclicencias__default(),
         new Object[] {
             new Object[] {
            P02BV2_A2266LegCuenAnio, P02BV2_A2245LegCuenLicPerFin, P02BV2_A2244LegCuenLicPerIni, P02BV2_A2243LegCuenLicTpo, P02BV2_A6LegNumero, P02BV2_A1EmpCod, P02BV2_A3CliCod, P02BV2_A2322LegCuLRecalc, P02BV2_A2248LegCuenDiasGoz, P02BV2_A2247LegCuenDiasCorres
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P02BV5_A2243LegCuenLicTpo, P02BV5_A6LegNumero, P02BV5_A1EmpCod, P02BV5_A3CliCod, P02BV5_A2266LegCuenAnio, P02BV5_A2321LegCuLIncluir, P02BV5_A2248LegCuenDiasGoz, P02BV5_A2247LegCuenDiasCorres, P02BV5_A2315LegCuLActVen, P02BV5_A2322LegCuLRecalc,
            P02BV5_A2304LegCuLiPVen, P02BV5_A2313LegCuLTotCons, P02BV5_A2314LegCuLTotCorr, P02BV5_A2302LegCuLiPCur, P02BV5_A2305LegCuLiPSaldo, P02BV5_A2303LegCuLiPAnt, P02BV5_A2329LegCuLLogDis
            }
            , new Object[] {
            P02BV6_A3CliCod, P02BV6_A1EmpCod, P02BV6_A6LegNumero, P02BV6_A2243LegCuenLicTpo, P02BV6_A2266LegCuenAnio, P02BV6_A2310LegCuLConsAnio, P02BV6_A2312LegCuLConsCnt, P02BV6_A2311LegCuLConsSec
            }
            , new Object[] {
            }
         }
      );
      AV47Pgmname = "asignarConsumosCCLicencias" ;
      /* GeneXus formulas. */
      AV47Pgmname = "asignarConsumosCCLicencias" ;
      Gx_err = (short)(0) ;
   }

   private byte AV48GXLvl9 ;
   private byte AV22EmpPerVacDes ;
   private byte GXv_int3[] ;
   private byte AV23EmpPerVacHas ;
   private byte GXv_int4[] ;
   private byte AV49GXLvl61 ;
   private short AV11EmpCod ;
   private short AV13cantAAsignar ;
   private short AV35original_cantAAsignar ;
   private short AV14LegCuLConsAnio ;
   private short A2266LegCuenAnio ;
   private short A1EmpCod ;
   private short A2248LegCuenDiasGoz ;
   private short A2247LegCuenDiasCorres ;
   private short AV40LegCuenDiasCorres ;
   private short AV30nones ;
   private short A2315LegCuLActVen ;
   private short A2304LegCuLiPVen ;
   private short A2302LegCuLiPCur ;
   private short A2305LegCuLiPSaldo ;
   private short A2303LegCuLiPAnt ;
   private short AV31LegCuenDiasGoz ;
   private short AV8LegCuLConsCnt ;
   private short AV28actual_LegCuLConsCnt ;
   private short AV42otrosAnios_LegCuLConsCnt ;
   private short A2310LegCuLConsAnio ;
   private short A2312LegCuLConsCnt ;
   private short A2311LegCuLConsSec ;
   private short AV25otorgados ;
   private short AV15auxCantAAsignar ;
   private short AV16disponibles ;
   private short AV41corrigiocant ;
   private short GXv_int2[] ;
   private short AV24LegCuLiPVen ;
   private short AV26LegCuLiPSaldo ;
   private short AV33anterior_LegCuLiPSaldo ;
   private short AV34anterior_LegCuLActVen ;
   private short AV27LegCuLiPCur ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV10LegNumero ;
   private int AV44egresoLiqNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int AV29EmpVacDisMax ;
   private int GXv_int6[] ;
   private int AV18LegCuLTotCons ;
   private int AV19LegCuLTotCorr ;
   private int A2313LegCuLTotCons ;
   private int A2314LegCuLTotCorr ;
   private java.math.BigDecimal AV20EmpFracVacAnt ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private java.math.BigDecimal AV21disponiblesPorUnaje ;
   private String AV36lic_orig_consumos ;
   private String AV9LegCuenLicTpo ;
   private String AV47Pgmname ;
   private String scmdbuf ;
   private String A2243LegCuenLicTpo ;
   private java.util.Date AV17iniFecha ;
   private java.util.Date A2244LegCuenLicPerIni ;
   private java.util.Date A2245LegCuenLicPerFin ;
   private java.util.Date AV43hoy ;
   private boolean gxexitloop ;
   private boolean A2322LegCuLRecalc ;
   private boolean AV38corrigio ;
   private boolean GXv_boolean1[] ;
   private boolean A2321LegCuLIncluir ;
   private String A2329LegCuLLogDis ;
   private String AV39LegCuLLogDis ;
   private IDataStoreProvider pr_default ;
   private short[] P02BV2_A2266LegCuenAnio ;
   private java.util.Date[] P02BV2_A2245LegCuenLicPerFin ;
   private java.util.Date[] P02BV2_A2244LegCuenLicPerIni ;
   private String[] P02BV2_A2243LegCuenLicTpo ;
   private int[] P02BV2_A6LegNumero ;
   private short[] P02BV2_A1EmpCod ;
   private int[] P02BV2_A3CliCod ;
   private boolean[] P02BV2_A2322LegCuLRecalc ;
   private short[] P02BV2_A2248LegCuenDiasGoz ;
   private short[] P02BV2_A2247LegCuenDiasCorres ;
   private String[] P02BV5_A2243LegCuenLicTpo ;
   private int[] P02BV5_A6LegNumero ;
   private short[] P02BV5_A1EmpCod ;
   private int[] P02BV5_A3CliCod ;
   private short[] P02BV5_A2266LegCuenAnio ;
   private boolean[] P02BV5_A2321LegCuLIncluir ;
   private short[] P02BV5_A2248LegCuenDiasGoz ;
   private short[] P02BV5_A2247LegCuenDiasCorres ;
   private short[] P02BV5_A2315LegCuLActVen ;
   private boolean[] P02BV5_A2322LegCuLRecalc ;
   private short[] P02BV5_A2304LegCuLiPVen ;
   private int[] P02BV5_A2313LegCuLTotCons ;
   private int[] P02BV5_A2314LegCuLTotCorr ;
   private short[] P02BV5_A2302LegCuLiPCur ;
   private short[] P02BV5_A2305LegCuLiPSaldo ;
   private short[] P02BV5_A2303LegCuLiPAnt ;
   private String[] P02BV5_A2329LegCuLLogDis ;
   private int[] P02BV6_A3CliCod ;
   private short[] P02BV6_A1EmpCod ;
   private int[] P02BV6_A6LegNumero ;
   private String[] P02BV6_A2243LegCuenLicTpo ;
   private short[] P02BV6_A2266LegCuenAnio ;
   private short[] P02BV6_A2310LegCuLConsAnio ;
   private short[] P02BV6_A2312LegCuLConsCnt ;
   private short[] P02BV6_A2311LegCuLConsSec ;
}

final  class asignarconsumoscclicencias__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02BV2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV14LegCuLConsAnio ,
                                          java.util.Date A2244LegCuenLicPerIni ,
                                          java.util.Date AV17iniFecha ,
                                          java.util.Date A2245LegCuenLicPerFin ,
                                          short A2266LegCuenAnio ,
                                          int AV12CliCod ,
                                          short AV11EmpCod ,
                                          int AV10LegNumero ,
                                          String AV9LegCuenLicTpo ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero ,
                                          String A2243LegCuenLicTpo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[7];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT LegCuenAnio, LegCuenLicPerFin, LegCuenLicPerIni, LegCuenLicTpo, LegNumero, EmpCod, CliCod, LegCuLRecalc, LegCuenDiasGoz, LegCuenDiasCorres FROM legajo_cuenta_licencias" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?))");
      if ( (0==AV14LegCuLConsAnio) )
      {
         addWhere(sWhereString, "(LegCuenLicPerIni <= ?)");
      }
      else
      {
         GXv_int7[4] = (byte)(1) ;
      }
      if ( (0==AV14LegCuLConsAnio) )
      {
         addWhere(sWhereString, "(LegCuenLicPerFin >= ?)");
      }
      else
      {
         GXv_int7[5] = (byte)(1) ;
      }
      if ( ! (0==AV14LegCuLConsAnio) )
      {
         addWhere(sWhereString, "(LegCuenAnio = ?)");
      }
      else
      {
         GXv_int7[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo" ;
      scmdbuf += " FOR UPDATE OF legajo_cuenta_licencias" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P02BV2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , (java.util.Date)dynConstraints[1] , (java.util.Date)dynConstraints[2] , (java.util.Date)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02BV2", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P02BV3", "SAVEPOINT gxupdate;UPDATE legajo_cuenta_licencias SET LegCuenDiasGoz=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P02BV4", "SAVEPOINT gxupdate;UPDATE legajo_cuenta_licencias SET LegCuenDiasGoz=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P02BV5", "SELECT LegCuenLicTpo, LegNumero, EmpCod, CliCod, LegCuenAnio, LegCuLIncluir, LegCuenDiasGoz, LegCuenDiasCorres, LegCuLActVen, LegCuLRecalc, LegCuLiPVen, LegCuLTotCons, LegCuLTotCorr, LegCuLiPCur, LegCuLiPSaldo, LegCuLiPAnt, LegCuLLogDis FROM legajo_cuenta_licencias WHERE (CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?)) AND (LegCuLIncluir = TRUE) ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio  FOR UPDATE OF legajo_cuenta_licencias",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02BV6", "SELECT CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLConsAnio, LegCuLConsCnt, LegCuLConsSec FROM legajo_cuenta_licenciasconsumos WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio = ? ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P02BV7", "SAVEPOINT gxupdate;UPDATE legajo_cuenta_licencias SET LegCuLActVen=?, LegCuLiPVen=?, LegCuLTotCons=?, LegCuLTotCorr=?, LegCuLiPCur=?, LegCuLiPSaldo=?, LegCuLiPAnt=?, LegCuLLogDis=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((int[]) buf[11])[0] = rslt.getInt(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               ((short[]) buf[13])[0] = rslt.getShort(14);
               ((short[]) buf[14])[0] = rslt.getShort(15);
               ((short[]) buf[15])[0] = rslt.getShort(16);
               ((String[]) buf[16])[0] = rslt.getLongVarchar(17);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[11]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[12]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setNLongVarchar(8, (String)parms[7], false);
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setString(12, (String)parms[11], 20);
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               return;
      }
   }

}

