package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liquidacionupdateredundancy extends GXProcedure
{
   public liquidacionupdateredundancy( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacionupdateredundancy.class ), "" );
   }

   public liquidacionupdateredundancy( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int[] aP0 ,
                          short[] aP1 )
   {
      liquidacionupdateredundancy.this.aP2 = new int[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int[] aP0 ,
                        short[] aP1 ,
                        int[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int[] aP0 ,
                             short[] aP1 ,
                             int[] aP2 )
   {
      liquidacionupdateredundancy.this.A3CliCod = aP0[0];
      this.aP0 = aP0;
      liquidacionupdateredundancy.this.A1EmpCod = aP1[0];
      this.aP1 = aP1;
      liquidacionupdateredundancy.this.A31LiqNro = aP2[0];
      this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor LIQUIDACIO2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A283LiqPeriodo = LIQUIDACIO2_A283LiqPeriodo[0] ;
         A32TLiqCod = LIQUIDACIO2_A32TLiqCod[0] ;
         n32TLiqCod = LIQUIDACIO2_n32TLiqCod[0] ;
         AV2GXV283 = A283LiqPeriodo ;
         AV3GXV32 = A32TLiqCod ;
         n32TLiqCod = false ;
         /* Optimized UPDATE. */
         /* Using cursor LIQUIDACIO3 */
         pr_default.execute(1, new Object[] {Boolean.valueOf(n32TLiqCod), AV3GXV32, AV2GXV283, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
         /* End optimized UPDATE. */
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = liquidacionupdateredundancy.this.A3CliCod;
      this.aP1[0] = liquidacionupdateredundancy.this.A1EmpCod;
      this.aP2[0] = liquidacionupdateredundancy.this.A31LiqNro;
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
      LIQUIDACIO2_A3CliCod = new int[1] ;
      LIQUIDACIO2_A1EmpCod = new short[1] ;
      LIQUIDACIO2_A31LiqNro = new int[1] ;
      LIQUIDACIO2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      LIQUIDACIO2_A32TLiqCod = new String[] {""} ;
      LIQUIDACIO2_n32TLiqCod = new boolean[] {false} ;
      A283LiqPeriodo = GXutil.nullDate() ;
      A32TLiqCod = "" ;
      AV2GXV283 = GXutil.nullDate() ;
      AV3GXV32 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacionupdateredundancy__default(),
         new Object[] {
             new Object[] {
            LIQUIDACIO2_A3CliCod, LIQUIDACIO2_A1EmpCod, LIQUIDACIO2_A31LiqNro, LIQUIDACIO2_A283LiqPeriodo, LIQUIDACIO2_A32TLiqCod, LIQUIDACIO2_n32TLiqCod
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A1EmpCod ;
   private short Gx_err ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private String scmdbuf ;
   private String A32TLiqCod ;
   private String AV3GXV32 ;
   private java.util.Date A283LiqPeriodo ;
   private java.util.Date AV2GXV283 ;
   private boolean n32TLiqCod ;
   private int[] aP2 ;
   private int[] aP0 ;
   private short[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] LIQUIDACIO2_A3CliCod ;
   private short[] LIQUIDACIO2_A1EmpCod ;
   private int[] LIQUIDACIO2_A31LiqNro ;
   private java.util.Date[] LIQUIDACIO2_A283LiqPeriodo ;
   private String[] LIQUIDACIO2_A32TLiqCod ;
   private boolean[] LIQUIDACIO2_n32TLiqCod ;
}

final  class liquidacionupdateredundancy__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("LIQUIDACIO2", "SELECT CliCod, EmpCod, LiqNro, LiqPeriodo, TLiqCod FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("LIQUIDACIO3", "UPDATE LiquidacionLegajo SET TLiqCod=?, LiqPeriodo=?  WHERE CliCod = ? and EmpCod = ? and LiqNro = ?", GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
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
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               stmt.setDate(2, (java.util.Date)parms[2]);
               stmt.setInt(3, ((Number) parms[3]).intValue());
               stmt.setShort(4, ((Number) parms[4]).shortValue());
               stmt.setInt(5, ((Number) parms[5]).intValue());
               return;
      }
   }

}

