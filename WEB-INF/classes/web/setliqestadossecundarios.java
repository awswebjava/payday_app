package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class setliqestadossecundarios extends GXProcedure
{
   public setliqestadossecundarios( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( setliqestadossecundarios.class ), "" );
   }

   public setliqestadossecundarios( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        byte aP3 ,
                        String aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             byte aP3 ,
                             String aP4 )
   {
      setliqestadossecundarios.this.AV12CliCod = aP0;
      setliqestadossecundarios.this.AV11EmpCod = aP1;
      setliqestadossecundarios.this.AV10LiqNro = aP2;
      setliqestadossecundarios.this.AV8LiquidacionEstado = aP3;
      setliqestadossecundarios.this.AV16PDFEstado = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV13LiqLSDDepEst ;
      GXv_int2[0] = GXt_int1 ;
      new web.getliqestdeplsd(remoteHandle, context).execute( AV12CliCod, AV11EmpCod, AV10LiqNro, GXv_int2) ;
      setliqestadossecundarios.this.GXt_int1 = GXv_int2[0] ;
      AV13LiqLSDDepEst = GXt_int1 ;
      if ( AV13LiqLSDDepEst != AV8LiquidacionEstado )
      {
         n2180LiqPDFEstado = false ;
         /* Optimized UPDATE. */
         /* Using cursor P02JB2 */
         pr_default.execute(0, new Object[] {Byte.valueOf(AV8LiquidacionEstado), Byte.valueOf(AV8LiquidacionEstado), Boolean.valueOf(n2180LiqPDFEstado), AV16PDFEstado, Byte.valueOf(AV8LiquidacionEstado), Integer.valueOf(AV12CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV10LiqNro)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
         /* End optimized UPDATE. */
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "setliqestadossecundarios");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int2 = new byte[1] ;
      A2180LiqPDFEstado = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.setliqestadossecundarios__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV8LiquidacionEstado ;
   private byte AV13LiqLSDDepEst ;
   private byte GXt_int1 ;
   private byte GXv_int2[] ;
   private byte A1403LiqAuxEstado ;
   private byte A2293LiqContrEst ;
   private byte A2292LiqLSDDepEst ;
   private short AV11EmpCod ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV10LiqNro ;
   private String AV16PDFEstado ;
   private String A2180LiqPDFEstado ;
   private boolean n2180LiqPDFEstado ;
   private IDataStoreProvider pr_default ;
}

final  class setliqestadossecundarios__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P02JB2", "UPDATE Liquidacion SET LiqAuxEstado=?, LiqContrEst=?, LiqPDFEstado=?, LiqLSDDepEst=?  WHERE CliCod = ? and EmpCod = ? and LiqNro = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 20);
               }
               stmt.setByte(4, ((Number) parms[4]).byteValue());
               stmt.setInt(5, ((Number) parms[5]).intValue());
               stmt.setShort(6, ((Number) parms[6]).shortValue());
               stmt.setInt(7, ((Number) parms[7]).intValue());
               return;
      }
   }

}

