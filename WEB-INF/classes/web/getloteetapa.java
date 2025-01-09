package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getloteetapa extends GXProcedure
{
   public getloteetapa( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getloteetapa.class ), "" );
   }

   public getloteetapa( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 ,
                            String aP3 ,
                            String aP4 )
   {
      getloteetapa.this.aP5 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        String aP4 ,
                        short[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             String aP4 ,
                             short[] aP5 )
   {
      getloteetapa.this.AV13CliCod = aP0;
      getloteetapa.this.AV9EmpCod = aP1;
      getloteetapa.this.AV12LiqNro = aP2;
      getloteetapa.this.AV11LiqBatchCod = aP3;
      getloteetapa.this.AV8LiqBatchSeccion = aP4;
      getloteetapa.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02JV2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV12LiqNro), AV11LiqBatchCod, AV8LiqBatchSeccion});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2373LiqBatchSeccion = P02JV2_A2373LiqBatchSeccion[0] ;
         A2372LiqBatchCod = P02JV2_A2372LiqBatchCod[0] ;
         A2371LiqBatchLiqNro = P02JV2_A2371LiqBatchLiqNro[0] ;
         A1EmpCod = P02JV2_A1EmpCod[0] ;
         A3CliCod = P02JV2_A3CliCod[0] ;
         A2374LiqBatchEtapa = P02JV2_A2374LiqBatchEtapa[0] ;
         AV10LiqBatchEtapa = A2374LiqBatchEtapa ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = getloteetapa.this.AV10LiqBatchEtapa;
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
      P02JV2_A2373LiqBatchSeccion = new String[] {""} ;
      P02JV2_A2372LiqBatchCod = new String[] {""} ;
      P02JV2_A2371LiqBatchLiqNro = new int[1] ;
      P02JV2_A1EmpCod = new short[1] ;
      P02JV2_A3CliCod = new int[1] ;
      P02JV2_A2374LiqBatchEtapa = new short[1] ;
      A2373LiqBatchSeccion = "" ;
      A2372LiqBatchCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getloteetapa__default(),
         new Object[] {
             new Object[] {
            P02JV2_A2373LiqBatchSeccion, P02JV2_A2372LiqBatchCod, P02JV2_A2371LiqBatchLiqNro, P02JV2_A1EmpCod, P02JV2_A3CliCod, P02JV2_A2374LiqBatchEtapa
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV10LiqBatchEtapa ;
   private short A1EmpCod ;
   private short A2374LiqBatchEtapa ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV12LiqNro ;
   private int A2371LiqBatchLiqNro ;
   private int A3CliCod ;
   private String AV8LiqBatchSeccion ;
   private String scmdbuf ;
   private String A2373LiqBatchSeccion ;
   private String AV11LiqBatchCod ;
   private String A2372LiqBatchCod ;
   private short[] aP5 ;
   private IDataStoreProvider pr_default ;
   private String[] P02JV2_A2373LiqBatchSeccion ;
   private String[] P02JV2_A2372LiqBatchCod ;
   private int[] P02JV2_A2371LiqBatchLiqNro ;
   private short[] P02JV2_A1EmpCod ;
   private int[] P02JV2_A3CliCod ;
   private short[] P02JV2_A2374LiqBatchEtapa ;
}

final  class getloteetapa__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02JV2", "SELECT LiqBatchSeccion, LiqBatchCod, LiqBatchLiqNro, EmpCod, CliCod, LiqBatchEtapa FROM LiquidacionLotes3 WHERE CliCod = ? and EmpCod = ? and LiqBatchLiqNro = ? and LiqBatchCod = ( ?) and LiqBatchSeccion = ( ?) ORDER BY CliCod, EmpCod, LiqBatchLiqNro, LiqBatchCod, LiqBatchSeccion ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
      }
   }

}

