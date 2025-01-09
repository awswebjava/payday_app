package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqestados extends GXProcedure
{
   public getliqestados( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqestados.class ), "" );
   }

   public getliqestados( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             byte[] aP3 ,
                             byte[] aP4 ,
                             byte[] aP5 ,
                             byte[] aP6 )
   {
      getliqestados.this.aP7 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        byte[] aP3 ,
                        byte[] aP4 ,
                        byte[] aP5 ,
                        byte[] aP6 ,
                        String[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             byte[] aP3 ,
                             byte[] aP4 ,
                             byte[] aP5 ,
                             byte[] aP6 ,
                             String[] aP7 )
   {
      getliqestados.this.AV10CliCod = aP0;
      getliqestados.this.AV11EmpCod = aP1;
      getliqestados.this.AV8LiqNro = aP2;
      getliqestados.this.aP3 = aP3;
      getliqestados.this.aP4 = aP4;
      getliqestados.this.aP5 = aP5;
      getliqestados.this.aP6 = aP6;
      getliqestados.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02JF2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV8LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P02JF2_A31LiqNro[0] ;
         A1EmpCod = P02JF2_A1EmpCod[0] ;
         A3CliCod = P02JF2_A3CliCod[0] ;
         A278LiqEstado = P02JF2_A278LiqEstado[0] ;
         A2292LiqLSDDepEst = P02JF2_A2292LiqLSDDepEst[0] ;
         A2293LiqContrEst = P02JF2_A2293LiqContrEst[0] ;
         A1403LiqAuxEstado = P02JF2_A1403LiqAuxEstado[0] ;
         A2180LiqPDFEstado = P02JF2_A2180LiqPDFEstado[0] ;
         n2180LiqPDFEstado = P02JF2_n2180LiqPDFEstado[0] ;
         AV9LiqEstado = A278LiqEstado ;
         AV12LiqLSDDepEst = A2292LiqLSDDepEst ;
         AV13LiqContrEst = A2293LiqContrEst ;
         AV14LiqAuxEstado = A1403LiqAuxEstado ;
         AV15LiqPDFEstado = A2180LiqPDFEstado ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getliqestados.this.AV9LiqEstado;
      this.aP4[0] = getliqestados.this.AV12LiqLSDDepEst;
      this.aP5[0] = getliqestados.this.AV13LiqContrEst;
      this.aP6[0] = getliqestados.this.AV14LiqAuxEstado;
      this.aP7[0] = getliqestados.this.AV15LiqPDFEstado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15LiqPDFEstado = "" ;
      scmdbuf = "" ;
      P02JF2_A31LiqNro = new int[1] ;
      P02JF2_A1EmpCod = new short[1] ;
      P02JF2_A3CliCod = new int[1] ;
      P02JF2_A278LiqEstado = new byte[1] ;
      P02JF2_A2292LiqLSDDepEst = new byte[1] ;
      P02JF2_A2293LiqContrEst = new byte[1] ;
      P02JF2_A1403LiqAuxEstado = new byte[1] ;
      P02JF2_A2180LiqPDFEstado = new String[] {""} ;
      P02JF2_n2180LiqPDFEstado = new boolean[] {false} ;
      A2180LiqPDFEstado = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqestados__default(),
         new Object[] {
             new Object[] {
            P02JF2_A31LiqNro, P02JF2_A1EmpCod, P02JF2_A3CliCod, P02JF2_A278LiqEstado, P02JF2_A2292LiqLSDDepEst, P02JF2_A2293LiqContrEst, P02JF2_A1403LiqAuxEstado, P02JF2_A2180LiqPDFEstado, P02JF2_n2180LiqPDFEstado
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV9LiqEstado ;
   private byte AV12LiqLSDDepEst ;
   private byte AV13LiqContrEst ;
   private byte AV14LiqAuxEstado ;
   private byte A278LiqEstado ;
   private byte A2292LiqLSDDepEst ;
   private byte A2293LiqContrEst ;
   private byte A1403LiqAuxEstado ;
   private short AV11EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV8LiqNro ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String AV15LiqPDFEstado ;
   private String scmdbuf ;
   private String A2180LiqPDFEstado ;
   private boolean n2180LiqPDFEstado ;
   private String[] aP7 ;
   private byte[] aP3 ;
   private byte[] aP4 ;
   private byte[] aP5 ;
   private byte[] aP6 ;
   private IDataStoreProvider pr_default ;
   private int[] P02JF2_A31LiqNro ;
   private short[] P02JF2_A1EmpCod ;
   private int[] P02JF2_A3CliCod ;
   private byte[] P02JF2_A278LiqEstado ;
   private byte[] P02JF2_A2292LiqLSDDepEst ;
   private byte[] P02JF2_A2293LiqContrEst ;
   private byte[] P02JF2_A1403LiqAuxEstado ;
   private String[] P02JF2_A2180LiqPDFEstado ;
   private boolean[] P02JF2_n2180LiqPDFEstado ;
}

final  class getliqestados__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02JF2", "SELECT LiqNro, EmpCod, CliCod, LiqEstado, LiqLSDDepEst, LiqContrEst, LiqAuxEstado, LiqPDFEstado FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
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
      }
   }

}

