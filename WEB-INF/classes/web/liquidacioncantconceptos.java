package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liquidacioncantconceptos extends GXProcedure
{
   public liquidacioncantconceptos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacioncantconceptos.class ), "" );
   }

   public liquidacioncantconceptos( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 ,
                            int aP3 )
   {
      liquidacioncantconceptos.this.aP4 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        short[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             short[] aP4 )
   {
      liquidacioncantconceptos.this.AV12CliCod = aP0;
      liquidacioncantconceptos.this.AV9EmpCod = aP1;
      liquidacioncantconceptos.this.AV11LiqNro = aP2;
      liquidacioncantconceptos.this.AV10LegNumero = aP3;
      liquidacioncantconceptos.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV13MostrarConcepto = (byte)(3) ;
      /* Optimized group. */
      /* Using cursor P00KV2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV11LiqNro), Integer.valueOf(AV10LegNumero), Byte.valueOf(AV13MostrarConcepto)});
      cV8LiqLegCntConc = P00KV2_AV8LiqLegCntConc[0] ;
      pr_default.close(0);
      AV8LiqLegCntConc = (short)(AV8LiqLegCntConc+cV8LiqLegCntConc*1) ;
      /* End optimized group. */
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = liquidacioncantconceptos.this.AV8LiqLegCntConc;
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
      P00KV2_AV8LiqLegCntConc = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacioncantconceptos__default(),
         new Object[] {
             new Object[] {
            P00KV2_AV8LiqLegCntConc
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV13MostrarConcepto ;
   private short AV9EmpCod ;
   private short AV8LiqLegCntConc ;
   private short cV8LiqLegCntConc ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV11LiqNro ;
   private int AV10LegNumero ;
   private String scmdbuf ;
   private short[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P00KV2_AV8LiqLegCntConc ;
}

final  class liquidacioncantconceptos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00KV2", "SELECT COUNT(*) FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and LiqDMostrar = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
      }
   }

}

