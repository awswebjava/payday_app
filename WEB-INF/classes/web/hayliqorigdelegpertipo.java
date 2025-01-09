package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class hayliqorigdelegpertipo extends GXProcedure
{
   public hayliqorigdelegpertipo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( hayliqorigdelegpertipo.class ), "" );
   }

   public hayliqorigdelegpertipo( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              java.util.Date aP3 ,
                              String aP4 )
   {
      hayliqorigdelegpertipo.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        String aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             String aP4 ,
                             boolean[] aP5 )
   {
      hayliqorigdelegpertipo.this.AV8CliCod = aP0;
      hayliqorigdelegpertipo.this.AV9EmpCod = aP1;
      hayliqorigdelegpertipo.this.AV10LegNumero = aP2;
      hayliqorigdelegpertipo.this.AV11LiqPeriodo = aP3;
      hayliqorigdelegpertipo.this.AV12TLiqCod = aP4;
      hayliqorigdelegpertipo.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P020D2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), AV12TLiqCod, AV11LiqPeriodo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P020D2_A31LiqNro[0] ;
         A32TLiqCod = P020D2_A32TLiqCod[0] ;
         n32TLiqCod = P020D2_n32TLiqCod[0] ;
         A283LiqPeriodo = P020D2_A283LiqPeriodo[0] ;
         A6LegNumero = P020D2_A6LegNumero[0] ;
         A2112LiqRelNro = P020D2_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P020D2_n2112LiqRelNro[0] ;
         A1EmpCod = P020D2_A1EmpCod[0] ;
         A3CliCod = P020D2_A3CliCod[0] ;
         A2112LiqRelNro = P020D2_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P020D2_n2112LiqRelNro[0] ;
         AV13hay = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      new web.msgdebug_prod(remoteHandle, context).execute( AV18Pgmname, httpContext.getMessage( "&CliCod: ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV18Pgmname, httpContext.getMessage( "&EmpCod: ", "")+GXutil.trim( GXutil.str( AV9EmpCod, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV18Pgmname, httpContext.getMessage( "&LegNumero: ", "")+GXutil.trim( GXutil.str( AV10LegNumero, 8, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV18Pgmname, httpContext.getMessage( "&LiqPeriodo: ", "")+GXutil.trim( localUtil.dtoc( AV11LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV18Pgmname, httpContext.getMessage( "&TLiqCod: ", "")+GXutil.trim( AV12TLiqCod)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV18Pgmname, httpContext.getMessage( "&hay: ", "")+GXutil.trim( GXutil.booltostr( AV13hay))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = hayliqorigdelegpertipo.this.AV13hay;
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
      P020D2_A31LiqNro = new int[1] ;
      P020D2_A32TLiqCod = new String[] {""} ;
      P020D2_n32TLiqCod = new boolean[] {false} ;
      P020D2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P020D2_A6LegNumero = new int[1] ;
      P020D2_A2112LiqRelNro = new int[1] ;
      P020D2_n2112LiqRelNro = new boolean[] {false} ;
      P020D2_A1EmpCod = new short[1] ;
      P020D2_A3CliCod = new int[1] ;
      A32TLiqCod = "" ;
      A283LiqPeriodo = GXutil.nullDate() ;
      AV18Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.hayliqorigdelegpertipo__default(),
         new Object[] {
             new Object[] {
            P020D2_A31LiqNro, P020D2_A32TLiqCod, P020D2_n32TLiqCod, P020D2_A283LiqPeriodo, P020D2_A6LegNumero, P020D2_A2112LiqRelNro, P020D2_n2112LiqRelNro, P020D2_A1EmpCod, P020D2_A3CliCod
            }
         }
      );
      AV18Pgmname = "hayLiqOrigDeLegPerTipo" ;
      /* GeneXus formulas. */
      AV18Pgmname = "hayLiqOrigDeLegPerTipo" ;
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A2112LiqRelNro ;
   private int A3CliCod ;
   private String AV12TLiqCod ;
   private String scmdbuf ;
   private String A32TLiqCod ;
   private String AV18Pgmname ;
   private java.util.Date AV11LiqPeriodo ;
   private java.util.Date A283LiqPeriodo ;
   private boolean AV13hay ;
   private boolean n32TLiqCod ;
   private boolean n2112LiqRelNro ;
   private boolean[] aP5 ;
   private IDataStoreProvider pr_default ;
   private int[] P020D2_A31LiqNro ;
   private String[] P020D2_A32TLiqCod ;
   private boolean[] P020D2_n32TLiqCod ;
   private java.util.Date[] P020D2_A283LiqPeriodo ;
   private int[] P020D2_A6LegNumero ;
   private int[] P020D2_A2112LiqRelNro ;
   private boolean[] P020D2_n2112LiqRelNro ;
   private short[] P020D2_A1EmpCod ;
   private int[] P020D2_A3CliCod ;
}

final  class hayliqorigdelegpertipo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P020D2", "SELECT T1.LiqNro, T1.TLiqCod, T1.LiqPeriodo, T1.LegNumero, T2.LiqRelNro, T1.EmpCod, T1.CliCod FROM (LiquidacionLegajo T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) WHERE (T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? and T1.TLiqCod = ( ?) and T1.LiqPeriodo = ?) AND (T2.LiqRelNro IS NULL) ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.TLiqCod, T1.LiqPeriodo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((short[]) buf[7])[0] = rslt.getShort(6);
               ((int[]) buf[8])[0] = rslt.getInt(7);
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
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
      }
   }

}

