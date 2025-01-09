package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtantiguedad extends GXProcedure
{
   public obtantiguedad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtantiguedad.class ), "" );
   }

   public obtantiguedad( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 ,
                            java.util.Date aP3 ,
                            java.util.Date aP4 ,
                            java.util.Date aP5 ,
                            short aP6 ,
                            boolean aP7 ,
                            short[] aP8 ,
                            short[] aP9 ,
                            short[] aP10 ,
                            String[] aP11 ,
                            String[] aP12 ,
                            short[] aP13 )
   {
      obtantiguedad.this.aP14 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
      return aP14[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        java.util.Date aP4 ,
                        java.util.Date aP5 ,
                        short aP6 ,
                        boolean aP7 ,
                        short[] aP8 ,
                        short[] aP9 ,
                        short[] aP10 ,
                        String[] aP11 ,
                        String[] aP12 ,
                        short[] aP13 ,
                        short[] aP14 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             java.util.Date aP4 ,
                             java.util.Date aP5 ,
                             short aP6 ,
                             boolean aP7 ,
                             short[] aP8 ,
                             short[] aP9 ,
                             short[] aP10 ,
                             String[] aP11 ,
                             String[] aP12 ,
                             short[] aP13 ,
                             short[] aP14 )
   {
      obtantiguedad.this.AV18CliCod = aP0;
      obtantiguedad.this.AV19EmpCod = aP1;
      obtantiguedad.this.AV20LegNumero = aP2;
      obtantiguedad.this.AV8FechaInicio = aP3;
      obtantiguedad.this.AV9FechaFinal = aP4;
      obtantiguedad.this.AV31desdeLegHisFecIng = aP5;
      obtantiguedad.this.AV32parmLimiteParaDias = aP6;
      obtantiguedad.this.AV38extenso = aP7;
      obtantiguedad.this.aP8 = aP8;
      obtantiguedad.this.aP9 = aP9;
      obtantiguedad.this.aP10 = aP10;
      obtantiguedad.this.aP11 = aP11;
      obtantiguedad.this.aP12 = aP12;
      obtantiguedad.this.aP13 = aP13;
      obtantiguedad.this.aP14 = aP14;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized group. */
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV31desdeLegHisFecIng ,
                                           A2253LegHisFecIng } ,
                                           new int[]{
                                           TypeConstants.DATE, TypeConstants.DATE
                                           }
      });
      /* Using cursor P006W2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV19EmpCod), Integer.valueOf(AV20LegNumero), AV31desdeLegHisFecIng});
      cV34cant = P006W2_AV34cant[0] ;
      pr_default.close(0);
      AV34cant = (short)(AV34cant+cV34cant*1) ;
      /* End optimized group. */
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV8FechaInicio)) )
      {
         AV40LegHisFecIng = AV8FechaInicio ;
         /* Execute user subroutine: 'UN PERIODO' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV44Pgmname, httpContext.getMessage( "cant ", "")+GXutil.trim( GXutil.str( AV34cant, 4, 0))) ;
         AV45GXLvl20 = (byte)(0) ;
         pr_default.dynParam(1, new Object[]{ new Object[]{
                                              AV31desdeLegHisFecIng ,
                                              A2253LegHisFecIng ,
                                              Boolean.valueOf(A2258LegHisAfecAnt) ,
                                              Integer.valueOf(AV18CliCod) ,
                                              Short.valueOf(AV19EmpCod) ,
                                              Integer.valueOf(AV20LegNumero) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Integer.valueOf(A6LegNumero) } ,
                                              new int[]{
                                              TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                              }
         });
         /* Using cursor P006W3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV19EmpCod), Integer.valueOf(AV20LegNumero), AV31desdeLegHisFecIng});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A2258LegHisAfecAnt = P006W3_A2258LegHisAfecAnt[0] ;
            A2253LegHisFecIng = P006W3_A2253LegHisFecIng[0] ;
            A6LegNumero = P006W3_A6LegNumero[0] ;
            A1EmpCod = P006W3_A1EmpCod[0] ;
            A3CliCod = P006W3_A3CliCod[0] ;
            A2254LegHisFecEgr = P006W3_A2254LegHisFecEgr[0] ;
            A2317LegHisMesesAnt = P006W3_A2317LegHisMesesAnt[0] ;
            A2257LegHisDiasAnt = P006W3_A2257LegHisDiasAnt[0] ;
            AV45GXLvl20 = (byte)(1) ;
            AV30i = (short)(AV30i+1) ;
            if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A2254LegHisFecEgr)) && ( AV30i < AV34cant ) )
            {
               AV21LegHisFecEgr = A2254LegHisFecEgr ;
               AV14antiguedadMeses = (short)(AV14antiguedadMeses+A2317LegHisMesesAnt) ;
               AV13antiguedadDias = (short)(AV13antiguedadDias+A2257LegHisDiasAnt) ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV44Pgmname, httpContext.getMessage( "suma previo &antiguedadMeses ", "")+GXutil.trim( GXutil.str( AV14antiguedadMeses, 4, 0))+httpContext.getMessage( " LegHisMesesAnt ", "")+GXutil.trim( GXutil.str( A2317LegHisMesesAnt, 4, 0))+httpContext.getMessage( " &antiguedadDias ", "")+GXutil.trim( GXutil.str( AV13antiguedadDias, 4, 0))+httpContext.getMessage( " LegHisDiasAnt ", "")+GXutil.trim( GXutil.str( A2257LegHisDiasAnt, 5, 0))) ;
            }
            else
            {
               AV21LegHisFecEgr = AV9FechaFinal ;
               GXv_int1[0] = AV22auxAntiguedadMeses ;
               GXv_int2[0] = AV23auxAntiguedadDias ;
               GXv_int3[0] = AV37auxRemanenteDias ;
               new web.diferenciamesesydias(remoteHandle, context).execute( AV18CliCod, A2253LegHisFecIng, AV21LegHisFecEgr, (short)(9999), true, GXv_int1, GXv_int2, GXv_int3) ;
               obtantiguedad.this.AV22auxAntiguedadMeses = GXv_int1[0] ;
               obtantiguedad.this.AV23auxAntiguedadDias = GXv_int2[0] ;
               obtantiguedad.this.AV37auxRemanenteDias = GXv_int3[0] ;
               AV14antiguedadMeses = (short)(AV14antiguedadMeses+AV22auxAntiguedadMeses) ;
               AV13antiguedadDias = (short)(AV13antiguedadDias+AV23auxAntiguedadDias) ;
               if ( AV34cant == 1 )
               {
                  AV36remanenteDias = AV37auxRemanenteDias ;
               }
               new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV44Pgmname, httpContext.getMessage( "saca dif LegHisFecIng ", "")+GXutil.trim( localUtil.dtoc( A2253LegHisFecIng, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &LegHisFecEgr ", "")+GXutil.trim( localUtil.dtoc( AV21LegHisFecEgr, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &antiguedadMeses ", "")+GXutil.trim( GXutil.str( AV14antiguedadMeses, 4, 0))+httpContext.getMessage( " &auxAntiguedadMeses ", "")+GXutil.trim( GXutil.str( AV22auxAntiguedadMeses, 4, 0))+httpContext.getMessage( " &antiguedadDias ", "")+GXutil.trim( GXutil.str( AV13antiguedadDias, 4, 0))+httpContext.getMessage( " &auxAntiguedadDias ", "")+GXutil.trim( GXutil.str( AV23auxAntiguedadDias, 4, 0))) ;
            }
            AV24periodosLog.add(GXutil.trim( localUtil.dtoc( A2253LegHisFecIng, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " al ", "")+GXutil.trim( localUtil.dtoc( AV21LegHisFecEgr, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")), 0);
            pr_default.readNext(1);
         }
         pr_default.close(1);
         if ( AV45GXLvl20 == 0 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV44Pgmname, httpContext.getMessage( "nnone clicod ", "")+GXutil.trim( GXutil.str( AV18CliCod, 6, 0))+httpContext.getMessage( " empcod ", "")+GXutil.trim( GXutil.str( AV19EmpCod, 4, 0))+httpContext.getMessage( " leg ", "")+GXutil.trim( GXutil.str( AV20LegNumero, 8, 0))+httpContext.getMessage( " &desdeLegHisFecIng ", "")+GXutil.trim( localUtil.dtoc( AV31desdeLegHisFecIng, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
            AV40LegHisFecIng = AV31desdeLegHisFecIng ;
            /* Execute user subroutine: 'UN PERIODO' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      if ( AV34cant > 1 )
      {
         if ( AV13antiguedadDias > 30 )
         {
            AV14antiguedadMeses = (short)(AV13antiguedadDias/ (double) (30)) ;
            AV36remanenteDias = (short)(((int)((AV13antiguedadDias) % (30)))) ;
         }
      }
      AV39outMeses = AV14antiguedadMeses ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV44Pgmname, httpContext.getMessage( "fechainicio ", "")+GXutil.trim( localUtil.dtoc( AV8FechaInicio, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " fecha final ", "")+GXutil.trim( localUtil.dtoc( AV9FechaFinal, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " meses ", "")+GXutil.trim( GXutil.str( AV14antiguedadMeses, 4, 0))+httpContext.getMessage( " anios ", "")+GXutil.trim( GXutil.str( AV12AntiguedadAnios, 4, 0))) ;
      GXv_int3[0] = AV14antiguedadMeses ;
      GXv_int2[0] = AV12AntiguedadAnios ;
      new web.transformarmesesaaniosymeses(remoteHandle, context).execute( GXv_int3, GXv_int2) ;
      obtantiguedad.this.AV14antiguedadMeses = GXv_int3[0] ;
      obtantiguedad.this.AV12AntiguedadAnios = GXv_int2[0] ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV44Pgmname, httpContext.getMessage( "despues de transf meses ", "")+GXutil.trim( GXutil.str( AV14antiguedadMeses, 4, 0))+httpContext.getMessage( " anios ", "")+GXutil.trim( GXutil.str( AV12AntiguedadAnios, 4, 0))) ;
      GXv_char4[0] = AV27ConveCodigo ;
      new web.empleadogetconvenio(remoteHandle, context).execute( AV18CliCod, AV19EmpCod, AV20LegNumero, GXv_char4) ;
      obtantiguedad.this.AV27ConveCodigo = GXv_char4[0] ;
      GXv_int3[0] = AV28PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV18CliCod, GXv_int3) ;
      obtantiguedad.this.AV28PaiCod = GXv_int3[0] ;
      GXv_int5[0] = (byte)(AV33minimoMesesVac) ;
      new web.getvacminmesesvac(remoteHandle, context).execute( AV18CliCod, AV28PaiCod, AV27ConveCodigo, AV9FechaFinal, GXv_int5) ;
      obtantiguedad.this.AV33minimoMesesVac = GXv_int5[0] ;
      if ( AV12AntiguedadAnios > 0 )
      {
         AV26LegCueAntAbr = GXutil.trim( GXutil.str( AV12AntiguedadAnios, 4, 0)) + httpContext.getMessage( " año", "") ;
         if ( AV38extenso )
         {
            AV25LiqDLog = httpContext.getMessage( "Empleado con ", "") ;
         }
         else
         {
            AV25LiqDLog = "" ;
         }
         AV25LiqDLog += GXutil.trim( GXutil.str( AV12AntiguedadAnios, 4, 0)) + httpContext.getMessage( " año", "") ;
         if ( AV12AntiguedadAnios > 1 )
         {
            AV25LiqDLog += httpContext.getMessage( "s", "") ;
            AV26LegCueAntAbr += httpContext.getMessage( "s", "") ;
         }
         /* Execute user subroutine: 'AGREGAR MESES' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( AV38extenso )
         {
            AV25LiqDLog += httpContext.getMessage( " de antiguedad", "") ;
         }
      }
      else
      {
         if ( (0==AV32parmLimiteParaDias) )
         {
            AV16Limite = AV33minimoMesesVac ;
         }
         else
         {
            AV16Limite = AV32parmLimiteParaDias ;
         }
         if ( AV14antiguedadMeses <= AV16Limite )
         {
            AV26LegCueAntAbr = GXutil.trim( GXutil.str( AV13antiguedadDias, 4, 0)) ;
            if ( AV38extenso )
            {
               AV25LiqDLog = httpContext.getMessage( "Empleado con ", "") ;
            }
            else
            {
               AV25LiqDLog = "" ;
            }
            if ( AV13antiguedadDias == 1 )
            {
               AV25LiqDLog += GXutil.trim( GXutil.str( AV13antiguedadDias, 4, 0)) + httpContext.getMessage( " día", "") ;
               AV26LegCueAntAbr += httpContext.getMessage( " día", "") ;
            }
            else
            {
               AV25LiqDLog += GXutil.trim( GXutil.str( AV13antiguedadDias, 4, 0)) + httpContext.getMessage( " días", "") ;
               AV26LegCueAntAbr += httpContext.getMessage( " días", "") ;
            }
            if ( AV38extenso )
            {
               AV25LiqDLog += httpContext.getMessage( " de antiguedad", "") ;
            }
         }
         else
         {
            AV26LegCueAntAbr += GXutil.trim( GXutil.str( AV14antiguedadMeses, 4, 0)) ;
            if ( AV38extenso )
            {
               AV25LiqDLog = httpContext.getMessage( "Empleado con ", "") ;
            }
            else
            {
               AV25LiqDLog = "" ;
            }
            if ( AV14antiguedadMeses == 1 )
            {
               AV26LegCueAntAbr += httpContext.getMessage( " mes", "") ;
               AV25LiqDLog += GXutil.trim( GXutil.str( AV14antiguedadMeses, 4, 0)) + httpContext.getMessage( " mes", "") ;
            }
            else
            {
               AV26LegCueAntAbr += httpContext.getMessage( " meses", "") ;
               AV25LiqDLog += GXutil.trim( GXutil.str( AV14antiguedadMeses, 4, 0)) + httpContext.getMessage( " meses", "") ;
            }
            if ( (0==AV36remanenteDias) && ( AV13antiguedadDias > 30 ) )
            {
               AV36remanenteDias = (short)(((int)((AV13antiguedadDias) % (30)))) ;
            }
            if ( ! (0==AV36remanenteDias) )
            {
               AV25LiqDLog += httpContext.getMessage( " y ", "") + GXutil.trim( GXutil.str( AV36remanenteDias, 4, 0)) + httpContext.getMessage( " día", "") ;
               if ( AV36remanenteDias > 1 )
               {
                  AV25LiqDLog += httpContext.getMessage( "s", "") ;
               }
            }
            if ( AV38extenso )
            {
               AV25LiqDLog += httpContext.getMessage( " de antiguedad", "") ;
            }
         }
      }
      if ( AV38extenso )
      {
         if ( AV24periodosLog.size() == 1 )
         {
            AV25LiqDLog += httpContext.getMessage( " del ", "") + GXutil.trim( (String)AV24periodosLog.elementAt(-1+1)) ;
         }
         else
         {
            AV25LiqDLog += httpContext.getMessage( " en los periodos ", "") ;
            AV30i = (short)(1) ;
            while ( AV30i <= AV24periodosLog.size() )
            {
               if ( AV30i == AV24periodosLog.size() )
               {
                  AV25LiqDLog += httpContext.getMessage( " y ", "") ;
               }
               else
               {
                  if ( AV30i > 1 )
                  {
                     AV25LiqDLog += ", " ;
                  }
               }
               AV25LiqDLog += httpContext.getMessage( "del ", "") + GXutil.trim( (String)AV24periodosLog.elementAt(-1+AV30i)) ;
               AV30i = (short)(AV30i+1) ;
            }
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'AGREGAR MESES' Routine */
      returnInSub = false ;
      if ( AV14antiguedadMeses > 0 )
      {
         AV25LiqDLog += httpContext.getMessage( " y ", "") + GXutil.trim( GXutil.str( AV14antiguedadMeses, 4, 0)) ;
         if ( AV14antiguedadMeses > 1 )
         {
            AV25LiqDLog += httpContext.getMessage( " meses", "") ;
         }
         else
         {
            AV25LiqDLog += httpContext.getMessage( " mes", "") ;
         }
      }
   }

   public void S121( )
   {
      /* 'UN PERIODO' Routine */
      returnInSub = false ;
      GXv_int3[0] = AV14antiguedadMeses ;
      GXv_int2[0] = AV13antiguedadDias ;
      GXv_int1[0] = AV36remanenteDias ;
      new web.diferenciamesesydias(remoteHandle, context).execute( AV18CliCod, AV40LegHisFecIng, AV9FechaFinal, (short)(9999), true, GXv_int3, GXv_int2, GXv_int1) ;
      obtantiguedad.this.AV14antiguedadMeses = GXv_int3[0] ;
      obtantiguedad.this.AV13antiguedadDias = GXv_int2[0] ;
      obtantiguedad.this.AV36remanenteDias = GXv_int1[0] ;
      AV24periodosLog.add(GXutil.trim( localUtil.dtoc( AV8FechaInicio, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " al ", "")+GXutil.trim( localUtil.dtoc( AV9FechaFinal, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")), 0);
   }

   protected void cleanup( )
   {
      this.aP8[0] = obtantiguedad.this.AV12AntiguedadAnios;
      this.aP9[0] = obtantiguedad.this.AV39outMeses;
      this.aP10[0] = obtantiguedad.this.AV13antiguedadDias;
      this.aP11[0] = obtantiguedad.this.AV25LiqDLog;
      this.aP12[0] = obtantiguedad.this.AV26LegCueAntAbr;
      this.aP13[0] = obtantiguedad.this.AV33minimoMesesVac;
      this.aP14[0] = obtantiguedad.this.AV34cant;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV25LiqDLog = "" ;
      AV26LegCueAntAbr = "" ;
      scmdbuf = "" ;
      A2253LegHisFecIng = GXutil.nullDate() ;
      P006W2_AV34cant = new short[1] ;
      AV40LegHisFecIng = GXutil.nullDate() ;
      AV44Pgmname = "" ;
      P006W3_A2258LegHisAfecAnt = new boolean[] {false} ;
      P006W3_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      P006W3_A6LegNumero = new int[1] ;
      P006W3_A1EmpCod = new short[1] ;
      P006W3_A3CliCod = new int[1] ;
      P006W3_A2254LegHisFecEgr = new java.util.Date[] {GXutil.nullDate()} ;
      P006W3_A2317LegHisMesesAnt = new short[1] ;
      P006W3_A2257LegHisDiasAnt = new int[1] ;
      A2254LegHisFecEgr = GXutil.nullDate() ;
      AV21LegHisFecEgr = GXutil.nullDate() ;
      AV24periodosLog = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27ConveCodigo = "" ;
      GXv_char4 = new String[1] ;
      GXv_int5 = new byte[1] ;
      GXv_int3 = new short[1] ;
      GXv_int2 = new short[1] ;
      GXv_int1 = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obtantiguedad__default(),
         new Object[] {
             new Object[] {
            P006W2_AV34cant
            }
            , new Object[] {
            P006W3_A2258LegHisAfecAnt, P006W3_A2253LegHisFecIng, P006W3_A6LegNumero, P006W3_A1EmpCod, P006W3_A3CliCod, P006W3_A2254LegHisFecEgr, P006W3_A2317LegHisMesesAnt, P006W3_A2257LegHisDiasAnt
            }
         }
      );
      AV44Pgmname = "ObtAntiguedad" ;
      /* GeneXus formulas. */
      AV44Pgmname = "ObtAntiguedad" ;
      Gx_err = (short)(0) ;
   }

   private byte AV45GXLvl20 ;
   private byte GXv_int5[] ;
   private short AV19EmpCod ;
   private short AV32parmLimiteParaDias ;
   private short AV12AntiguedadAnios ;
   private short AV39outMeses ;
   private short AV13antiguedadDias ;
   private short AV33minimoMesesVac ;
   private short AV34cant ;
   private short cV34cant ;
   private short A1EmpCod ;
   private short A2317LegHisMesesAnt ;
   private short AV30i ;
   private short AV14antiguedadMeses ;
   private short AV22auxAntiguedadMeses ;
   private short AV23auxAntiguedadDias ;
   private short AV37auxRemanenteDias ;
   private short AV36remanenteDias ;
   private short AV28PaiCod ;
   private short AV16Limite ;
   private short GXv_int3[] ;
   private short GXv_int2[] ;
   private short GXv_int1[] ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int AV20LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A2257LegHisDiasAnt ;
   private String scmdbuf ;
   private String AV44Pgmname ;
   private String AV27ConveCodigo ;
   private String GXv_char4[] ;
   private java.util.Date AV8FechaInicio ;
   private java.util.Date AV9FechaFinal ;
   private java.util.Date AV31desdeLegHisFecIng ;
   private java.util.Date A2253LegHisFecIng ;
   private java.util.Date AV40LegHisFecIng ;
   private java.util.Date A2254LegHisFecEgr ;
   private java.util.Date AV21LegHisFecEgr ;
   private boolean AV38extenso ;
   private boolean returnInSub ;
   private boolean A2258LegHisAfecAnt ;
   private String AV25LiqDLog ;
   private String AV26LegCueAntAbr ;
   private short[] aP14 ;
   private short[] aP8 ;
   private short[] aP9 ;
   private short[] aP10 ;
   private String[] aP11 ;
   private String[] aP12 ;
   private short[] aP13 ;
   private IDataStoreProvider pr_default ;
   private short[] P006W2_AV34cant ;
   private boolean[] P006W3_A2258LegHisAfecAnt ;
   private java.util.Date[] P006W3_A2253LegHisFecIng ;
   private int[] P006W3_A6LegNumero ;
   private short[] P006W3_A1EmpCod ;
   private int[] P006W3_A3CliCod ;
   private java.util.Date[] P006W3_A2254LegHisFecEgr ;
   private short[] P006W3_A2317LegHisMesesAnt ;
   private int[] P006W3_A2257LegHisDiasAnt ;
   private GXSimpleCollection<String> AV24periodosLog ;
}

final  class obtantiguedad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P006W2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          java.util.Date AV31desdeLegHisFecIng ,
                                          java.util.Date A2253LegHisFecIng )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[4];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM legajo_permanencia" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LegNumero = ?)");
      addWhere(sWhereString, "(LegHisAfecAnt = TRUE)");
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV31desdeLegHisFecIng)) )
      {
         addWhere(sWhereString, "(LegHisFecIng <= ?)");
      }
      else
      {
         GXv_int6[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
   }

   protected Object[] conditional_P006W3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          java.util.Date AV31desdeLegHisFecIng ,
                                          java.util.Date A2253LegHisFecIng ,
                                          boolean A2258LegHisAfecAnt ,
                                          int AV18CliCod ,
                                          short AV19EmpCod ,
                                          int AV20LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[4];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT LegHisAfecAnt, LegHisFecIng, LegNumero, EmpCod, CliCod, LegHisFecEgr, LegHisMesesAnt, LegHisDiasAnt FROM legajo_permanencia" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LegNumero = ?)");
      addWhere(sWhereString, "(LegHisAfecAnt = TRUE)");
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV31desdeLegHisFecIng)) )
      {
         addWhere(sWhereString, "(LegHisFecIng <= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LegNumero, LegHisFecIng" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
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
                  return conditional_P006W2(context, remoteHandle, httpContext, (java.util.Date)dynConstraints[0] , (java.util.Date)dynConstraints[1] );
            case 1 :
                  return conditional_P006W3(context, remoteHandle, httpContext, (java.util.Date)dynConstraints[0] , (java.util.Date)dynConstraints[1] , ((Boolean) dynConstraints[2]).booleanValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006W2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006W3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               return;
            case 1 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
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
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[7]);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[7]);
               }
               return;
      }
   }

}

