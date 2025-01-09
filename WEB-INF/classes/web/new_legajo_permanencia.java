package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class new_legajo_permanencia extends GXProcedure
{
   public new_legajo_permanencia( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( new_legajo_permanencia.class ), "" );
   }

   public new_legajo_permanencia( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        java.util.Date aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        boolean aP7 ,
                        String aP8 ,
                        boolean aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             java.util.Date aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             String aP8 ,
                             boolean aP9 )
   {
      new_legajo_permanencia.this.AV13CliCod = aP0;
      new_legajo_permanencia.this.AV12EmpCod = aP1;
      new_legajo_permanencia.this.AV11LegNumero = aP2;
      new_legajo_permanencia.this.AV10LegHisFecIng = aP3;
      new_legajo_permanencia.this.AV9LegHisFecEgr = aP4;
      new_legajo_permanencia.this.AV8LegHisFecTel = aP5;
      new_legajo_permanencia.this.AV18LegHisMotCod = aP6;
      new_legajo_permanencia.this.AV14LegHisAfecAnt = aP7;
      new_legajo_permanencia.this.AV21modoPalabra = aP8;
      new_legajo_permanencia.this.AV22calcularAntiguedad = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV25GXLvl1 = (byte)(0) ;
      /* Using cursor P02A22 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV11LegNumero), AV10LegHisFecIng});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2253LegHisFecIng = P02A22_A2253LegHisFecIng[0] ;
         A6LegNumero = P02A22_A6LegNumero[0] ;
         A1EmpCod = P02A22_A1EmpCod[0] ;
         A3CliCod = P02A22_A3CliCod[0] ;
         A2254LegHisFecEgr = P02A22_A2254LegHisFecEgr[0] ;
         A2255LegHisFecTel = P02A22_A2255LegHisFecTel[0] ;
         A2330LegHisMotCod = P02A22_A2330LegHisMotCod[0] ;
         n2330LegHisMotCod = P02A22_n2330LegHisMotCod[0] ;
         A2252LegHisLiqNro = P02A22_A2252LegHisLiqNro[0] ;
         n2252LegHisLiqNro = P02A22_n2252LegHisLiqNro[0] ;
         A2258LegHisAfecAnt = P02A22_A2258LegHisAfecAnt[0] ;
         A2257LegHisDiasAnt = P02A22_A2257LegHisDiasAnt[0] ;
         A2317LegHisMesesAnt = P02A22_A2317LegHisMesesAnt[0] ;
         A2318LegHisAniosAnt = P02A22_A2318LegHisAniosAnt[0] ;
         A2319LegHisAntTexto = P02A22_A2319LegHisAntTexto[0] ;
         A2331LegHisAntTxtAbr = P02A22_A2331LegHisAntTxtAbr[0] ;
         AV25GXLvl1 = (byte)(1) ;
         if ( GXutil.strcmp(AV21modoPalabra, httpContext.getMessage( "recalculo", "")) != 0 )
         {
            A2254LegHisFecEgr = AV9LegHisFecEgr ;
            A2255LegHisFecTel = AV8LegHisFecTel ;
            if ( ! (GXutil.strcmp("", AV18LegHisMotCod)==0) )
            {
               A2330LegHisMotCod = AV18LegHisMotCod ;
               n2330LegHisMotCod = false ;
            }
            else
            {
               A2330LegHisMotCod = "" ;
               n2330LegHisMotCod = false ;
               n2330LegHisMotCod = true ;
            }
            A2252LegHisLiqNro = 0 ;
            n2252LegHisLiqNro = false ;
            n2252LegHisLiqNro = true ;
            A2258LegHisAfecAnt = AV14LegHisAfecAnt ;
         }
         if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV9LegHisFecEgr)) )
         {
            A2257LegHisDiasAnt = 0 ;
            A2317LegHisMesesAnt = (short)(0) ;
            A2318LegHisAniosAnt = (short)(0) ;
            A2319LegHisAntTexto = "" ;
            A2331LegHisAntTxtAbr = "" ;
         }
         else
         {
            GXv_int1[0] = AV15LegHisAniosAnt ;
            GXv_int2[0] = (short)(DecimalUtil.decToDouble(AV26Antiguedadmeses)) ;
            GXv_int3[0] = (short)(DecimalUtil.decToDouble(AV27Antiguedaddias)) ;
            GXv_char4[0] = AV19LegHisAntTxtAbr ;
            GXv_char5[0] = "" ;
            GXv_int6[0] = (short)(0) ;
            GXv_int7[0] = (short)(0) ;
            new web.obtantiguedad(remoteHandle, context).execute( AV13CliCod, AV12EmpCod, AV11LegNumero, AV10LegHisFecIng, AV9LegHisFecEgr, AV20vaciaFecha, (short)(1), false, GXv_int1, GXv_int2, GXv_int3, GXv_char4, GXv_char5, GXv_int6, GXv_int7) ;
            new_legajo_permanencia.this.AV15LegHisAniosAnt = GXv_int1[0] ;
            new_legajo_permanencia.this.AV26Antiguedadmeses = DecimalUtil.doubleToDec(GXv_int2[0]) ;
            new_legajo_permanencia.this.AV27Antiguedaddias = DecimalUtil.doubleToDec(GXv_int3[0]) ;
            new_legajo_permanencia.this.AV19LegHisAntTxtAbr = GXv_char4[0] ;
            A2257LegHisDiasAnt = (int)(DecimalUtil.decToDouble(AV27Antiguedaddias)) ;
            A2317LegHisMesesAnt = (short)(DecimalUtil.decToDouble(AV26Antiguedadmeses)) ;
            A2318LegHisAniosAnt = AV15LegHisAniosAnt ;
            A2331LegHisAntTxtAbr = AV19LegHisAntTxtAbr ;
            if ( ! AV22calcularAntiguedad )
            {
               A2319LegHisAntTexto = "" ;
            }
            else
            {
               GXv_int7[0] = AV15LegHisAniosAnt ;
               GXv_int6[0] = (short)(DecimalUtil.decToDouble(AV26Antiguedadmeses)) ;
               GXv_int3[0] = (short)(DecimalUtil.decToDouble(AV27Antiguedaddias)) ;
               GXv_char5[0] = AV17LegHisAntTexto ;
               GXv_char4[0] = "" ;
               GXv_int2[0] = (short)(0) ;
               GXv_int1[0] = (short)(0) ;
               new web.obtantiguedad(remoteHandle, context).execute( AV13CliCod, AV12EmpCod, AV11LegNumero, AV20vaciaFecha, AV9LegHisFecEgr, AV20vaciaFecha, (short)(1), false, GXv_int7, GXv_int6, GXv_int3, GXv_char5, GXv_char4, GXv_int2, GXv_int1) ;
               new_legajo_permanencia.this.AV15LegHisAniosAnt = GXv_int7[0] ;
               new_legajo_permanencia.this.AV26Antiguedadmeses = DecimalUtil.doubleToDec(GXv_int6[0]) ;
               new_legajo_permanencia.this.AV27Antiguedaddias = DecimalUtil.doubleToDec(GXv_int3[0]) ;
               new_legajo_permanencia.this.AV17LegHisAntTexto = GXv_char5[0] ;
               A2319LegHisAntTexto = AV17LegHisAntTexto ;
            }
         }
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         /* Using cursor P02A23 */
         pr_default.execute(1, new Object[] {A2254LegHisFecEgr, A2255LegHisFecTel, Boolean.valueOf(n2330LegHisMotCod), A2330LegHisMotCod, Boolean.valueOf(n2252LegHisLiqNro), Integer.valueOf(A2252LegHisLiqNro), Boolean.valueOf(A2258LegHisAfecAnt), Integer.valueOf(A2257LegHisDiasAnt), Short.valueOf(A2317LegHisMesesAnt), Short.valueOf(A2318LegHisAniosAnt), A2319LegHisAntTexto, A2331LegHisAntTxtAbr, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2253LegHisFecIng});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_permanencia");
         if (true) break;
         /* Using cursor P02A24 */
         pr_default.execute(2, new Object[] {A2254LegHisFecEgr, A2255LegHisFecTel, Boolean.valueOf(n2330LegHisMotCod), A2330LegHisMotCod, Boolean.valueOf(n2252LegHisLiqNro), Integer.valueOf(A2252LegHisLiqNro), Boolean.valueOf(A2258LegHisAfecAnt), Integer.valueOf(A2257LegHisDiasAnt), Short.valueOf(A2317LegHisMesesAnt), Short.valueOf(A2318LegHisAniosAnt), A2319LegHisAntTexto, A2331LegHisAntTxtAbr, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2253LegHisFecIng});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_permanencia");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV25GXLvl1 == 0 )
      {
         /*
            INSERT RECORD ON TABLE legajo_permanencia

         */
         A3CliCod = AV13CliCod ;
         A1EmpCod = AV12EmpCod ;
         A6LegNumero = AV11LegNumero ;
         A2253LegHisFecIng = AV10LegHisFecIng ;
         A2254LegHisFecEgr = AV9LegHisFecEgr ;
         A2255LegHisFecTel = AV8LegHisFecTel ;
         if ( ! (GXutil.strcmp("", AV18LegHisMotCod)==0) )
         {
            A2330LegHisMotCod = AV18LegHisMotCod ;
            n2330LegHisMotCod = false ;
         }
         else
         {
            A2330LegHisMotCod = "" ;
            n2330LegHisMotCod = false ;
            n2330LegHisMotCod = true ;
         }
         A2252LegHisLiqNro = 0 ;
         n2252LegHisLiqNro = false ;
         n2252LegHisLiqNro = true ;
         if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV9LegHisFecEgr)) )
         {
            A2257LegHisDiasAnt = 0 ;
            A2317LegHisMesesAnt = (short)(0) ;
            A2318LegHisAniosAnt = (short)(0) ;
            A2319LegHisAntTexto = "" ;
            A2331LegHisAntTxtAbr = "" ;
         }
         else
         {
            GXv_int7[0] = AV15LegHisAniosAnt ;
            GXv_int6[0] = (short)(DecimalUtil.decToDouble(AV26Antiguedadmeses)) ;
            GXv_int3[0] = (short)(DecimalUtil.decToDouble(AV27Antiguedaddias)) ;
            GXv_char5[0] = AV19LegHisAntTxtAbr ;
            GXv_char4[0] = "" ;
            GXv_int2[0] = (short)(0) ;
            GXv_int1[0] = (short)(0) ;
            new web.obtantiguedad(remoteHandle, context).execute( AV13CliCod, AV12EmpCod, AV11LegNumero, AV10LegHisFecIng, AV9LegHisFecEgr, AV20vaciaFecha, (short)(1), false, GXv_int7, GXv_int6, GXv_int3, GXv_char5, GXv_char4, GXv_int2, GXv_int1) ;
            new_legajo_permanencia.this.AV15LegHisAniosAnt = GXv_int7[0] ;
            new_legajo_permanencia.this.AV26Antiguedadmeses = DecimalUtil.doubleToDec(GXv_int6[0]) ;
            new_legajo_permanencia.this.AV27Antiguedaddias = DecimalUtil.doubleToDec(GXv_int3[0]) ;
            new_legajo_permanencia.this.AV19LegHisAntTxtAbr = GXv_char5[0] ;
            A2257LegHisDiasAnt = (int)(DecimalUtil.decToDouble(AV27Antiguedaddias)) ;
            A2317LegHisMesesAnt = (short)(DecimalUtil.decToDouble(AV26Antiguedadmeses)) ;
            A2318LegHisAniosAnt = AV15LegHisAniosAnt ;
            A2331LegHisAntTxtAbr = AV19LegHisAntTxtAbr ;
            GXv_int7[0] = AV15LegHisAniosAnt ;
            GXv_int6[0] = (short)(DecimalUtil.decToDouble(AV26Antiguedadmeses)) ;
            GXv_int3[0] = (short)(DecimalUtil.decToDouble(AV27Antiguedaddias)) ;
            GXv_char5[0] = AV17LegHisAntTexto ;
            GXv_char4[0] = "" ;
            GXv_int2[0] = (short)(0) ;
            GXv_int1[0] = (short)(0) ;
            new web.obtantiguedad(remoteHandle, context).execute( AV13CliCod, AV12EmpCod, AV11LegNumero, AV20vaciaFecha, AV9LegHisFecEgr, AV10LegHisFecIng, (short)(1), false, GXv_int7, GXv_int6, GXv_int3, GXv_char5, GXv_char4, GXv_int2, GXv_int1) ;
            new_legajo_permanencia.this.AV15LegHisAniosAnt = GXv_int7[0] ;
            new_legajo_permanencia.this.AV26Antiguedadmeses = DecimalUtil.doubleToDec(GXv_int6[0]) ;
            new_legajo_permanencia.this.AV27Antiguedaddias = DecimalUtil.doubleToDec(GXv_int3[0]) ;
            new_legajo_permanencia.this.AV17LegHisAntTexto = GXv_char5[0] ;
            A2319LegHisAntTexto = AV17LegHisAntTexto ;
         }
         A2258LegHisAfecAnt = AV14LegHisAfecAnt ;
         /* Using cursor P02A25 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2253LegHisFecIng, A2254LegHisFecEgr, A2255LegHisFecTel, Boolean.valueOf(n2252LegHisLiqNro), Integer.valueOf(A2252LegHisLiqNro), Integer.valueOf(A2257LegHisDiasAnt), Boolean.valueOf(A2258LegHisAfecAnt), Boolean.valueOf(n2330LegHisMotCod), A2330LegHisMotCod, Short.valueOf(A2317LegHisMesesAnt), Short.valueOf(A2318LegHisAniosAnt), A2319LegHisAntTexto, A2331LegHisAntTxtAbr});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_permanencia");
         if ( (pr_default.getStatus(3) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "new_legajo_permanencia");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P02A22_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      P02A22_A6LegNumero = new int[1] ;
      P02A22_A1EmpCod = new short[1] ;
      P02A22_A3CliCod = new int[1] ;
      P02A22_A2254LegHisFecEgr = new java.util.Date[] {GXutil.nullDate()} ;
      P02A22_A2255LegHisFecTel = new java.util.Date[] {GXutil.nullDate()} ;
      P02A22_A2330LegHisMotCod = new String[] {""} ;
      P02A22_n2330LegHisMotCod = new boolean[] {false} ;
      P02A22_A2252LegHisLiqNro = new int[1] ;
      P02A22_n2252LegHisLiqNro = new boolean[] {false} ;
      P02A22_A2258LegHisAfecAnt = new boolean[] {false} ;
      P02A22_A2257LegHisDiasAnt = new int[1] ;
      P02A22_A2317LegHisMesesAnt = new short[1] ;
      P02A22_A2318LegHisAniosAnt = new short[1] ;
      P02A22_A2319LegHisAntTexto = new String[] {""} ;
      P02A22_A2331LegHisAntTxtAbr = new String[] {""} ;
      A2253LegHisFecIng = GXutil.nullDate() ;
      A2254LegHisFecEgr = GXutil.nullDate() ;
      A2255LegHisFecTel = GXutil.nullDate() ;
      A2330LegHisMotCod = "" ;
      A2319LegHisAntTexto = "" ;
      A2331LegHisAntTxtAbr = "" ;
      AV20vaciaFecha = GXutil.nullDate() ;
      AV26Antiguedadmeses = DecimalUtil.ZERO ;
      AV27Antiguedaddias = DecimalUtil.ZERO ;
      AV19LegHisAntTxtAbr = "" ;
      AV17LegHisAntTexto = "" ;
      GXv_int7 = new short[1] ;
      GXv_int6 = new short[1] ;
      GXv_int3 = new short[1] ;
      GXv_char5 = new String[1] ;
      GXv_char4 = new String[1] ;
      GXv_int2 = new short[1] ;
      GXv_int1 = new short[1] ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.new_legajo_permanencia__default(),
         new Object[] {
             new Object[] {
            P02A22_A2253LegHisFecIng, P02A22_A6LegNumero, P02A22_A1EmpCod, P02A22_A3CliCod, P02A22_A2254LegHisFecEgr, P02A22_A2255LegHisFecTel, P02A22_A2330LegHisMotCod, P02A22_n2330LegHisMotCod, P02A22_A2252LegHisLiqNro, P02A22_n2252LegHisLiqNro,
            P02A22_A2258LegHisAfecAnt, P02A22_A2257LegHisDiasAnt, P02A22_A2317LegHisMesesAnt, P02A22_A2318LegHisAniosAnt, P02A22_A2319LegHisAntTexto, P02A22_A2331LegHisAntTxtAbr
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV25GXLvl1 ;
   private short AV12EmpCod ;
   private short A1EmpCod ;
   private short A2317LegHisMesesAnt ;
   private short A2318LegHisAniosAnt ;
   private short AV15LegHisAniosAnt ;
   private short GXv_int7[] ;
   private short GXv_int6[] ;
   private short GXv_int3[] ;
   private short GXv_int2[] ;
   private short GXv_int1[] ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV11LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A2252LegHisLiqNro ;
   private int A2257LegHisDiasAnt ;
   private int GX_INS284 ;
   private java.math.BigDecimal AV26Antiguedadmeses ;
   private java.math.BigDecimal AV27Antiguedaddias ;
   private String AV18LegHisMotCod ;
   private String AV21modoPalabra ;
   private String scmdbuf ;
   private String A2330LegHisMotCod ;
   private String GXv_char5[] ;
   private String GXv_char4[] ;
   private String Gx_emsg ;
   private java.util.Date AV10LegHisFecIng ;
   private java.util.Date AV9LegHisFecEgr ;
   private java.util.Date AV8LegHisFecTel ;
   private java.util.Date A2253LegHisFecIng ;
   private java.util.Date A2254LegHisFecEgr ;
   private java.util.Date A2255LegHisFecTel ;
   private java.util.Date AV20vaciaFecha ;
   private boolean AV14LegHisAfecAnt ;
   private boolean AV22calcularAntiguedad ;
   private boolean n2330LegHisMotCod ;
   private boolean n2252LegHisLiqNro ;
   private boolean A2258LegHisAfecAnt ;
   private String A2319LegHisAntTexto ;
   private String AV17LegHisAntTexto ;
   private String A2331LegHisAntTxtAbr ;
   private String AV19LegHisAntTxtAbr ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P02A22_A2253LegHisFecIng ;
   private int[] P02A22_A6LegNumero ;
   private short[] P02A22_A1EmpCod ;
   private int[] P02A22_A3CliCod ;
   private java.util.Date[] P02A22_A2254LegHisFecEgr ;
   private java.util.Date[] P02A22_A2255LegHisFecTel ;
   private String[] P02A22_A2330LegHisMotCod ;
   private boolean[] P02A22_n2330LegHisMotCod ;
   private int[] P02A22_A2252LegHisLiqNro ;
   private boolean[] P02A22_n2252LegHisLiqNro ;
   private boolean[] P02A22_A2258LegHisAfecAnt ;
   private int[] P02A22_A2257LegHisDiasAnt ;
   private short[] P02A22_A2317LegHisMesesAnt ;
   private short[] P02A22_A2318LegHisAniosAnt ;
   private String[] P02A22_A2319LegHisAntTexto ;
   private String[] P02A22_A2331LegHisAntTxtAbr ;
}

final  class new_legajo_permanencia__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02A22", "SELECT LegHisFecIng, LegNumero, EmpCod, CliCod, LegHisFecEgr, LegHisFecTel, LegHisMotCod, LegHisLiqNro, LegHisAfecAnt, LegHisDiasAnt, LegHisMesesAnt, LegHisAniosAnt, LegHisAntTexto, LegHisAntTxtAbr FROM legajo_permanencia WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegHisFecIng = ? ORDER BY CliCod, EmpCod, LegNumero, LegHisFecIng  LIMIT 1 FOR UPDATE OF legajo_permanencia",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P02A23", "SAVEPOINT gxupdate;UPDATE legajo_permanencia SET LegHisFecEgr=?, LegHisFecTel=?, LegHisMotCod=?, LegHisLiqNro=?, LegHisAfecAnt=?, LegHisDiasAnt=?, LegHisMesesAnt=?, LegHisAniosAnt=?, LegHisAntTexto=?, LegHisAntTxtAbr=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegHisFecIng = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P02A24", "SAVEPOINT gxupdate;UPDATE legajo_permanencia SET LegHisFecEgr=?, LegHisFecTel=?, LegHisMotCod=?, LegHisLiqNro=?, LegHisAfecAnt=?, LegHisDiasAnt=?, LegHisMesesAnt=?, LegHisAniosAnt=?, LegHisAntTexto=?, LegHisAntTxtAbr=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegHisFecIng = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P02A25", "SAVEPOINT gxupdate;INSERT INTO legajo_permanencia(CliCod, EmpCod, LegNumero, LegHisFecIng, LegHisFecEgr, LegHisFecTel, LegHisLiqNro, LegHisDiasAnt, LegHisAfecAnt, LegHisMotCod, LegHisMesesAnt, LegHisAniosAnt, LegHisAntTexto, LegHisAntTxtAbr, LegHisManual) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((int[]) buf[8])[0] = rslt.getInt(8);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((boolean[]) buf[10])[0] = rslt.getBoolean(9);
               ((int[]) buf[11])[0] = rslt.getInt(10);
               ((short[]) buf[12])[0] = rslt.getShort(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
               ((String[]) buf[14])[0] = rslt.getLongVarchar(13);
               ((String[]) buf[15])[0] = rslt.getVarchar(14);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 1 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setDate(2, (java.util.Date)parms[1]);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 20);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(4, ((Number) parms[5]).intValue());
               }
               stmt.setBoolean(5, ((Boolean) parms[6]).booleanValue());
               stmt.setInt(6, ((Number) parms[7]).intValue());
               stmt.setShort(7, ((Number) parms[8]).shortValue());
               stmt.setShort(8, ((Number) parms[9]).shortValue());
               stmt.setNLongVarchar(9, (String)parms[10], false);
               stmt.setVarchar(10, (String)parms[11], 40, false);
               stmt.setInt(11, ((Number) parms[12]).intValue());
               stmt.setShort(12, ((Number) parms[13]).shortValue());
               stmt.setInt(13, ((Number) parms[14]).intValue());
               stmt.setDate(14, (java.util.Date)parms[15]);
               return;
            case 2 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setDate(2, (java.util.Date)parms[1]);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 20);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(4, ((Number) parms[5]).intValue());
               }
               stmt.setBoolean(5, ((Boolean) parms[6]).booleanValue());
               stmt.setInt(6, ((Number) parms[7]).intValue());
               stmt.setShort(7, ((Number) parms[8]).shortValue());
               stmt.setShort(8, ((Number) parms[9]).shortValue());
               stmt.setNLongVarchar(9, (String)parms[10], false);
               stmt.setVarchar(10, (String)parms[11], 40, false);
               stmt.setInt(11, ((Number) parms[12]).intValue());
               stmt.setShort(12, ((Number) parms[13]).shortValue());
               stmt.setInt(13, ((Number) parms[14]).intValue());
               stmt.setDate(14, (java.util.Date)parms[15]);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setDate(6, (java.util.Date)parms[5]);
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(7, ((Number) parms[7]).intValue());
               }
               stmt.setInt(8, ((Number) parms[8]).intValue());
               stmt.setBoolean(9, ((Boolean) parms[9]).booleanValue());
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(10, (String)parms[11], 20);
               }
               stmt.setShort(11, ((Number) parms[12]).shortValue());
               stmt.setShort(12, ((Number) parms[13]).shortValue());
               stmt.setNLongVarchar(13, (String)parms[14], false);
               stmt.setVarchar(14, (String)parms[15], 40, false);
               return;
      }
   }

}

