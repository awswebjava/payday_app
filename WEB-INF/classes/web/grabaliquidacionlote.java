package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class grabaliquidacionlote extends GXProcedure
{
   public grabaliquidacionlote( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( grabaliquidacionlote.class ), "" );
   }

   public grabaliquidacionlote( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        String aP4 ,
                        short aP5 ,
                        String aP6 ,
                        GXSimpleCollection<Integer> aP7 ,
                        String aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             String aP4 ,
                             short aP5 ,
                             String aP6 ,
                             GXSimpleCollection<Integer> aP7 ,
                             String aP8 )
   {
      grabaliquidacionlote.this.AV8CliCod = aP0;
      grabaliquidacionlote.this.AV9EmpCod = aP1;
      grabaliquidacionlote.this.AV17LiqNro = aP2;
      grabaliquidacionlote.this.AV40LiqBatchCod = aP3;
      grabaliquidacionlote.this.AV46LiqBatchSeccion = aP4;
      grabaliquidacionlote.this.AV44parmLiqBatchEtapa = aP5;
      grabaliquidacionlote.this.AV43parmLiqBatchError = aP6;
      grabaliquidacionlote.this.AV23LegNumero = aP7;
      grabaliquidacionlote.this.AV49parmLiqbatchDaemon = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_dtime1 = AV47ahora ;
      GXv_dtime2[0] = GXt_dtime1 ;
      new web.getahora(remoteHandle, context).execute( AV8CliCod, GXv_dtime2) ;
      grabaliquidacionlote.this.GXt_dtime1 = GXv_dtime2[0] ;
      AV47ahora = GXt_dtime1 ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV52Pgmname, httpContext.getMessage( "CliCod: ", "")+GXutil.str( AV8CliCod, 6, 0)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV52Pgmname, httpContext.getMessage( "EmpCod: ", "")+GXutil.str( AV9EmpCod, 4, 0)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV52Pgmname, httpContext.getMessage( "LiqBatchLiqNro: ", "")+GXutil.str( AV39LiqBatchLiqNro, 8, 0)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV52Pgmname, httpContext.getMessage( "LiqBatchCod: ", "")+AV40LiqBatchCod) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV52Pgmname, httpContext.getMessage( "LiqBatchSeccion: ", "")+AV46LiqBatchSeccion) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV52Pgmname, httpContext.getMessage( "LiqBatchEtapa: ", "")+GXutil.str( AV41LiqBatchEtapa, 4, 0)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV52Pgmname, httpContext.getMessage( "LiqBatchError: ", "")+AV42LiqBatchError) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV52Pgmname, httpContext.getMessage( "&parmLiqbatchDaemon: ", "")+AV49parmLiqbatchDaemon) ;
      AV42LiqBatchError = AV43parmLiqBatchError ;
      AV41LiqBatchEtapa = AV44parmLiqBatchEtapa ;
      AV48LiqbatchDaemon = AV49parmLiqbatchDaemon ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV52Pgmname, httpContext.getMessage( "&&LiqbatchDaemon: ", "")+AV48LiqbatchDaemon) ;
      /* Using cursor P029U2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV17LiqNro), AV40LiqBatchCod, AV46LiqBatchSeccion});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2373LiqBatchSeccion = P029U2_A2373LiqBatchSeccion[0] ;
         A2372LiqBatchCod = P029U2_A2372LiqBatchCod[0] ;
         A2371LiqBatchLiqNro = P029U2_A2371LiqBatchLiqNro[0] ;
         A1EmpCod = P029U2_A1EmpCod[0] ;
         A3CliCod = P029U2_A3CliCod[0] ;
         A2374LiqBatchEtapa = P029U2_A2374LiqBatchEtapa[0] ;
         A2375LiqBatchError = P029U2_A2375LiqBatchError[0] ;
         A2376LiqBatchErrN = P029U2_A2376LiqBatchErrN[0] ;
         if ( (0==AV41LiqBatchEtapa) )
         {
            AV41LiqBatchEtapa = A2374LiqBatchEtapa ;
         }
         if ( (GXutil.strcmp("", AV42LiqBatchError)==0) )
         {
            AV42LiqBatchError = A2375LiqBatchError ;
            AV45LiqBatchErrN = A2376LiqBatchErrN ;
         }
         else
         {
            AV45LiqBatchErrN = (short)(1) ;
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV52Pgmname, "------------------------------------------- "+GXutil.str( AV8CliCod, 6, 0)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV52Pgmname, httpContext.getMessage( "LiqBatchEtapa: ", "")+GXutil.str( AV41LiqBatchEtapa, 4, 0)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV52Pgmname, httpContext.getMessage( "LiqBatchError: ", "")+AV42LiqBatchError) ;
      AV54GXLvl83 = (byte)(0) ;
      /* Optimized UPDATE. */
      /* Using cursor P029U3 */
      pr_default.execute(1, new Object[] {AV47ahora, AV42LiqBatchError, Short.valueOf(AV45LiqBatchErrN), Short.valueOf(AV41LiqBatchEtapa), Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV17LiqNro), AV40LiqBatchCod, AV46LiqBatchSeccion});
      if ( (pr_default.getStatus(1) != 101) )
      {
         AV54GXLvl83 = (byte)(1) ;
      }
      Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLotes3");
      /* End optimized UPDATE. */
      if ( AV54GXLvl83 == 0 )
      {
         /*
            INSERT RECORD ON TABLE LiquidacionLotes3

         */
         A3CliCod = AV8CliCod ;
         A1EmpCod = AV9EmpCod ;
         A2371LiqBatchLiqNro = AV17LiqNro ;
         A2372LiqBatchCod = AV40LiqBatchCod ;
         A2373LiqBatchSeccion = AV46LiqBatchSeccion ;
         A2374LiqBatchEtapa = AV41LiqBatchEtapa ;
         A2375LiqBatchError = AV42LiqBatchError ;
         A2376LiqBatchErrN = AV45LiqBatchErrN ;
         A2378LiqBatchLegajos = GXutil.trim( AV23LegNumero.toJSonString(false)) ;
         A2389LiqBatchIni = AV47ahora ;
         A2398LiqbatchDaemon = AV48LiqbatchDaemon ;
         /* Using cursor P029U4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A2371LiqBatchLiqNro), A2372LiqBatchCod, A2373LiqBatchSeccion, Short.valueOf(A2374LiqBatchEtapa), A2375LiqBatchError, Short.valueOf(A2376LiqBatchErrN), A2378LiqBatchLegajos, A2389LiqBatchIni, A2398LiqbatchDaemon});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLotes3");
         if ( (pr_default.getStatus(2) == 1) )
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
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV52Pgmname, httpContext.getMessage( "insert", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "grabaliquidacionlote");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV47ahora = GXutil.resetTime( GXutil.nullDate() );
      GXt_dtime1 = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime2 = new java.util.Date[1] ;
      AV52Pgmname = "" ;
      AV42LiqBatchError = "" ;
      AV48LiqbatchDaemon = "" ;
      scmdbuf = "" ;
      P029U2_A2373LiqBatchSeccion = new String[] {""} ;
      P029U2_A2372LiqBatchCod = new String[] {""} ;
      P029U2_A2371LiqBatchLiqNro = new int[1] ;
      P029U2_A1EmpCod = new short[1] ;
      P029U2_A3CliCod = new int[1] ;
      P029U2_A2374LiqBatchEtapa = new short[1] ;
      P029U2_A2375LiqBatchError = new String[] {""} ;
      P029U2_A2376LiqBatchErrN = new short[1] ;
      A2373LiqBatchSeccion = "" ;
      A2372LiqBatchCod = "" ;
      A2375LiqBatchError = "" ;
      A2390LiqBatchFin = GXutil.resetTime( GXutil.nullDate() );
      A2378LiqBatchLegajos = "" ;
      A2389LiqBatchIni = GXutil.resetTime( GXutil.nullDate() );
      A2398LiqbatchDaemon = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.grabaliquidacionlote__default(),
         new Object[] {
             new Object[] {
            P029U2_A2373LiqBatchSeccion, P029U2_A2372LiqBatchCod, P029U2_A2371LiqBatchLiqNro, P029U2_A1EmpCod, P029U2_A3CliCod, P029U2_A2374LiqBatchEtapa, P029U2_A2375LiqBatchError, P029U2_A2376LiqBatchErrN
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV52Pgmname = "grabaLiquidacionLote" ;
      /* GeneXus formulas. */
      AV52Pgmname = "grabaLiquidacionLote" ;
      Gx_err = (short)(0) ;
   }

   private byte AV54GXLvl83 ;
   private short AV9EmpCod ;
   private short AV44parmLiqBatchEtapa ;
   private short AV41LiqBatchEtapa ;
   private short A1EmpCod ;
   private short A2374LiqBatchEtapa ;
   private short A2376LiqBatchErrN ;
   private short AV45LiqBatchErrN ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV17LiqNro ;
   private int AV39LiqBatchLiqNro ;
   private int A2371LiqBatchLiqNro ;
   private int A3CliCod ;
   private int GX_INS296 ;
   private String AV46LiqBatchSeccion ;
   private String AV49parmLiqbatchDaemon ;
   private String AV52Pgmname ;
   private String AV48LiqbatchDaemon ;
   private String scmdbuf ;
   private String A2373LiqBatchSeccion ;
   private String A2398LiqbatchDaemon ;
   private String Gx_emsg ;
   private java.util.Date AV47ahora ;
   private java.util.Date GXt_dtime1 ;
   private java.util.Date GXv_dtime2[] ;
   private java.util.Date A2390LiqBatchFin ;
   private java.util.Date A2389LiqBatchIni ;
   private String AV40LiqBatchCod ;
   private String AV43parmLiqBatchError ;
   private String AV42LiqBatchError ;
   private String A2372LiqBatchCod ;
   private String A2375LiqBatchError ;
   private String A2378LiqBatchLegajos ;
   private GXSimpleCollection<Integer> AV23LegNumero ;
   private IDataStoreProvider pr_default ;
   private String[] P029U2_A2373LiqBatchSeccion ;
   private String[] P029U2_A2372LiqBatchCod ;
   private int[] P029U2_A2371LiqBatchLiqNro ;
   private short[] P029U2_A1EmpCod ;
   private int[] P029U2_A3CliCod ;
   private short[] P029U2_A2374LiqBatchEtapa ;
   private String[] P029U2_A2375LiqBatchError ;
   private short[] P029U2_A2376LiqBatchErrN ;
}

final  class grabaliquidacionlote__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P029U2", "SELECT LiqBatchSeccion, LiqBatchCod, LiqBatchLiqNro, EmpCod, CliCod, LiqBatchEtapa, LiqBatchError, LiqBatchErrN FROM LiquidacionLotes3 WHERE CliCod = ? and EmpCod = ? and LiqBatchLiqNro = ? and LiqBatchCod = ( ?) and LiqBatchSeccion = ( ?) ORDER BY CliCod, EmpCod, LiqBatchLiqNro, LiqBatchCod, LiqBatchSeccion ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P029U3", "UPDATE LiquidacionLotes3 SET LiqBatchFin=?, LiqBatchError=?, LiqBatchErrN=?, LiqBatchEtapa=?  WHERE CliCod = ? and EmpCod = ? and LiqBatchLiqNro = ? and LiqBatchCod = ( ?) and LiqBatchSeccion = ( ?)", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P029U4", "SAVEPOINT gxupdate;INSERT INTO LiquidacionLotes3(CliCod, EmpCod, LiqBatchLiqNro, LiqBatchCod, LiqBatchSeccion, LiqBatchEtapa, LiqBatchError, LiqBatchErrN, LiqBatchLegajos, LiqBatchIni, LiqbatchDaemon, LiqBatchLegSum, LiqBatchFin) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, FALSE, DATE '00010101');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
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
               stmt.setVarchar(4, (String)parms[3], 40);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 1 :
               stmt.setDateTime(1, (java.util.Date)parms[0], false, true);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setVarchar(8, (String)parms[7], 40);
               stmt.setString(9, (String)parms[8], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setVarchar(7, (String)parms[6], 400, false);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setVarchar(9, (String)parms[8], 4000, false);
               stmt.setDateTime(10, (java.util.Date)parms[9], false, true);
               stmt.setString(11, (String)parms[10], 36);
               return;
      }
   }

}

