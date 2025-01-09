package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liqseterror extends GXProcedure
{
   public liqseterror( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liqseterror.class ), "" );
   }

   public liqseterror( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        boolean aP3 ,
                        boolean aP4 ,
                        boolean aP5 ,
                        boolean aP6 ,
                        boolean aP7 ,
                        String aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             boolean aP3 ,
                             boolean aP4 ,
                             boolean aP5 ,
                             boolean aP6 ,
                             boolean aP7 ,
                             String aP8 )
   {
      liqseterror.this.AV8CliCod = aP0;
      liqseterror.this.AV9EmpCod = aP1;
      liqseterror.this.AV10LiqNro = aP2;
      liqseterror.this.AV16PrinListo = aP3;
      liqseterror.this.AV13DepLSDListo = aP4;
      liqseterror.this.AV12ContrListo = aP5;
      liqseterror.this.AV14OtrosListo = aP6;
      liqseterror.this.AV15PDFListo = aP7;
      liqseterror.this.AV11error = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02B32 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P02B32_A31LiqNro[0] ;
         A1EmpCod = P02B32_A1EmpCod[0] ;
         A3CliCod = P02B32_A3CliCod[0] ;
         A766LiqError = P02B32_A766LiqError[0] ;
         A278LiqEstado = P02B32_A278LiqEstado[0] ;
         A2292LiqLSDDepEst = P02B32_A2292LiqLSDDepEst[0] ;
         A2293LiqContrEst = P02B32_A2293LiqContrEst[0] ;
         A1403LiqAuxEstado = P02B32_A1403LiqAuxEstado[0] ;
         A2180LiqPDFEstado = P02B32_A2180LiqPDFEstado[0] ;
         n2180LiqPDFEstado = P02B32_n2180LiqPDFEstado[0] ;
         AV17LiqError = A766LiqError ;
         AV18LiqEstado = A278LiqEstado ;
         AV19LiqLSDDepEst = A2292LiqLSDDepEst ;
         AV20LiqContrEst = A2293LiqContrEst ;
         AV21LiqAuxEstado = A1403LiqAuxEstado ;
         AV22LiqPDFEstado = A2180LiqPDFEstado ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( ! (GXutil.strcmp("", AV17LiqError)==0) && ! (GXutil.strcmp("", AV11error)==0) )
      {
         AV17LiqError += ". " ;
      }
      AV17LiqError += GXutil.trim( AV11error) ;
      if ( ! AV16PrinListo )
      {
         AV18LiqEstado = (byte)(2) ;
      }
      if ( ! AV13DepLSDListo )
      {
         AV19LiqLSDDepEst = (byte)(2) ;
      }
      if ( ! AV12ContrListo )
      {
         AV20LiqContrEst = (byte)(2) ;
      }
      if ( ! AV14OtrosListo )
      {
         AV21LiqAuxEstado = (byte)(2) ;
      }
      if ( ! AV15PDFListo )
      {
         AV22LiqPDFEstado = "Error" ;
      }
      n2180LiqPDFEstado = false ;
      /* Optimized UPDATE. */
      /* Using cursor P02B33 */
      pr_default.execute(1, new Object[] {Boolean.valueOf(n2180LiqPDFEstado), AV22LiqPDFEstado, Byte.valueOf(AV21LiqAuxEstado), Byte.valueOf(AV20LiqContrEst), Byte.valueOf(AV19LiqLSDDepEst), Byte.valueOf(AV18LiqEstado), AV17LiqError, Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LiqNro)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
      /* End optimized UPDATE. */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "liqseterror");
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
      P02B32_A31LiqNro = new int[1] ;
      P02B32_A1EmpCod = new short[1] ;
      P02B32_A3CliCod = new int[1] ;
      P02B32_A766LiqError = new String[] {""} ;
      P02B32_A278LiqEstado = new byte[1] ;
      P02B32_A2292LiqLSDDepEst = new byte[1] ;
      P02B32_A2293LiqContrEst = new byte[1] ;
      P02B32_A1403LiqAuxEstado = new byte[1] ;
      P02B32_A2180LiqPDFEstado = new String[] {""} ;
      P02B32_n2180LiqPDFEstado = new boolean[] {false} ;
      A766LiqError = "" ;
      A2180LiqPDFEstado = "" ;
      AV17LiqError = "" ;
      AV22LiqPDFEstado = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liqseterror__default(),
         new Object[] {
             new Object[] {
            P02B32_A31LiqNro, P02B32_A1EmpCod, P02B32_A3CliCod, P02B32_A766LiqError, P02B32_A278LiqEstado, P02B32_A2292LiqLSDDepEst, P02B32_A2293LiqContrEst, P02B32_A1403LiqAuxEstado, P02B32_A2180LiqPDFEstado, P02B32_n2180LiqPDFEstado
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A278LiqEstado ;
   private byte A2292LiqLSDDepEst ;
   private byte A2293LiqContrEst ;
   private byte A1403LiqAuxEstado ;
   private byte AV18LiqEstado ;
   private byte AV19LiqLSDDepEst ;
   private byte AV20LiqContrEst ;
   private byte AV21LiqAuxEstado ;
   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LiqNro ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String A2180LiqPDFEstado ;
   private String AV22LiqPDFEstado ;
   private boolean AV16PrinListo ;
   private boolean AV13DepLSDListo ;
   private boolean AV12ContrListo ;
   private boolean AV14OtrosListo ;
   private boolean AV15PDFListo ;
   private boolean n2180LiqPDFEstado ;
   private String AV11error ;
   private String A766LiqError ;
   private String AV17LiqError ;
   private IDataStoreProvider pr_default ;
   private int[] P02B32_A31LiqNro ;
   private short[] P02B32_A1EmpCod ;
   private int[] P02B32_A3CliCod ;
   private String[] P02B32_A766LiqError ;
   private byte[] P02B32_A278LiqEstado ;
   private byte[] P02B32_A2292LiqLSDDepEst ;
   private byte[] P02B32_A2293LiqContrEst ;
   private byte[] P02B32_A1403LiqAuxEstado ;
   private String[] P02B32_A2180LiqPDFEstado ;
   private boolean[] P02B32_n2180LiqPDFEstado ;
}

final  class liqseterror__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02B32", "SELECT LiqNro, EmpCod, CliCod, LiqError, LiqEstado, LiqLSDDepEst, LiqContrEst, LiqAuxEstado, LiqPDFEstado FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P02B33", "UPDATE Liquidacion SET LiqPDFEstado=?, LiqAuxEstado=?, LiqContrEst=?, LiqLSDDepEst=?, LiqEstado=?, LiqError=?  WHERE CliCod = ? and EmpCod = ? and LiqNro = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
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
               stmt.setByte(2, ((Number) parms[2]).byteValue());
               stmt.setByte(3, ((Number) parms[3]).byteValue());
               stmt.setByte(4, ((Number) parms[4]).byteValue());
               stmt.setByte(5, ((Number) parms[5]).byteValue());
               stmt.setVarchar(6, (String)parms[6], 400, false);
               stmt.setInt(7, ((Number) parms[7]).intValue());
               stmt.setShort(8, ((Number) parms[8]).shortValue());
               stmt.setInt(9, ((Number) parms[9]).intValue());
               return;
      }
   }

}

