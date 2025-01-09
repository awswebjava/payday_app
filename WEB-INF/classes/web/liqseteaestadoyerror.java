package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liqseteaestadoyerror extends GXProcedure
{
   public liqseteaestadoyerror( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liqseteaestadoyerror.class ), "" );
   }

   public liqseteaestadoyerror( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              String aP3 ,
                              byte aP4 ,
                              byte aP5 )
   {
      liqseteaestadoyerror.this.aP6 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        byte aP4 ,
                        byte aP5 ,
                        boolean[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             byte aP4 ,
                             byte aP5 ,
                             boolean[] aP6 )
   {
      liqseteaestadoyerror.this.AV14CliCod = aP0;
      liqseteaestadoyerror.this.AV13EmpCod = aP1;
      liqseteaestadoyerror.this.AV12LiqNro = aP2;
      liqseteaestadoyerror.this.AV11LiqError = aP3;
      liqseteaestadoyerror.this.AV10LiqEstado = aP4;
      liqseteaestadoyerror.this.AV8LiqAuxEstado = aP5;
      liqseteaestadoyerror.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01Z52 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV14CliCod), Short.valueOf(AV13EmpCod), Integer.valueOf(AV12LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P01Z52_A31LiqNro[0] ;
         A1EmpCod = P01Z52_A1EmpCod[0] ;
         A3CliCod = P01Z52_A3CliCod[0] ;
         A766LiqError = P01Z52_A766LiqError[0] ;
         A278LiqEstado = P01Z52_A278LiqEstado[0] ;
         A1403LiqAuxEstado = P01Z52_A1403LiqAuxEstado[0] ;
         A766LiqError = AV11LiqError ;
         A278LiqEstado = AV10LiqEstado ;
         A1403LiqAuxEstado = AV8LiqAuxEstado ;
         AV9existe = true ;
         /* Using cursor P01Z53 */
         pr_default.execute(1, new Object[] {A766LiqError, Byte.valueOf(A278LiqEstado), Byte.valueOf(A1403LiqAuxEstado), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = liqseteaestadoyerror.this.AV9existe;
      Application.commitDataStores(context, remoteHandle, pr_default, "liqseteaestadoyerror");
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
      P01Z52_A31LiqNro = new int[1] ;
      P01Z52_A1EmpCod = new short[1] ;
      P01Z52_A3CliCod = new int[1] ;
      P01Z52_A766LiqError = new String[] {""} ;
      P01Z52_A278LiqEstado = new byte[1] ;
      P01Z52_A1403LiqAuxEstado = new byte[1] ;
      A766LiqError = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liqseteaestadoyerror__default(),
         new Object[] {
             new Object[] {
            P01Z52_A31LiqNro, P01Z52_A1EmpCod, P01Z52_A3CliCod, P01Z52_A766LiqError, P01Z52_A278LiqEstado, P01Z52_A1403LiqAuxEstado
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV10LiqEstado ;
   private byte AV8LiqAuxEstado ;
   private byte A278LiqEstado ;
   private byte A1403LiqAuxEstado ;
   private short AV13EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV14CliCod ;
   private int AV12LiqNro ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean AV9existe ;
   private String AV11LiqError ;
   private String A766LiqError ;
   private boolean[] aP6 ;
   private IDataStoreProvider pr_default ;
   private int[] P01Z52_A31LiqNro ;
   private short[] P01Z52_A1EmpCod ;
   private int[] P01Z52_A3CliCod ;
   private String[] P01Z52_A766LiqError ;
   private byte[] P01Z52_A278LiqEstado ;
   private byte[] P01Z52_A1403LiqAuxEstado ;
}

final  class liqseteaestadoyerror__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01Z52", "SELECT LiqNro, EmpCod, CliCod, LiqError, LiqEstado, LiqAuxEstado FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro  FOR UPDATE OF Liquidacion",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01Z53", "SAVEPOINT gxupdate;UPDATE Liquidacion SET LiqError=?, LiqEstado=?, LiqAuxEstado=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
      }
   }

}

