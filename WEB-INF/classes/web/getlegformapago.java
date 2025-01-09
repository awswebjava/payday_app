package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlegformapago extends GXProcedure
{
   public getlegformapago( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlegformapago.class ), "" );
   }

   public getlegformapago( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 )
   {
      getlegformapago.this.aP3 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        byte[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             byte[] aP3 )
   {
      getlegformapago.this.AV11CliCod = aP0;
      getlegformapago.this.AV10EmpCod = aP1;
      getlegformapago.this.AV8LegNumero = aP2;
      getlegformapago.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P026R2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P026R2_A6LegNumero[0] ;
         A1EmpCod = P026R2_A1EmpCod[0] ;
         A3CliCod = P026R2_A3CliCod[0] ;
         A248LegFormaPago = P026R2_A248LegFormaPago[0] ;
         AV9LegFormaPago = A248LegFormaPago ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getlegformapago.this.AV9LegFormaPago;
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
      P026R2_A6LegNumero = new int[1] ;
      P026R2_A1EmpCod = new short[1] ;
      P026R2_A3CliCod = new int[1] ;
      P026R2_A248LegFormaPago = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlegformapago__default(),
         new Object[] {
             new Object[] {
            P026R2_A6LegNumero, P026R2_A1EmpCod, P026R2_A3CliCod, P026R2_A248LegFormaPago
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV9LegFormaPago ;
   private byte A248LegFormaPago ;
   private short AV10EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private byte[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P026R2_A6LegNumero ;
   private short[] P026R2_A1EmpCod ;
   private int[] P026R2_A3CliCod ;
   private byte[] P026R2_A248LegFormaPago ;
}

final  class getlegformapago__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P026R2", "SELECT LegNumero, EmpCod, CliCod, LegFormaPago FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

