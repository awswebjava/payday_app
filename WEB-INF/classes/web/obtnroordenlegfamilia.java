package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtnroordenlegfamilia extends GXProcedure
{
   public obtnroordenlegfamilia( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtnroordenlegfamilia.class ), "" );
   }

   public obtnroordenlegfamilia( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 )
   {
      obtnroordenlegfamilia.this.aP3 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short[] aP3 )
   {
      obtnroordenlegfamilia.this.AV11CliCod = aP0;
      obtnroordenlegfamilia.this.AV8EmpCod = aP1;
      obtnroordenlegfamilia.this.AV9LegNumero = aP2;
      obtnroordenlegfamilia.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10LegOrden = (short)(0) ;
      /* Using cursor P001I2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P001I2_A3CliCod[0] ;
         A1EmpCod = P001I2_A1EmpCod[0] ;
         A6LegNumero = P001I2_A6LegNumero[0] ;
         A29LegOrden = P001I2_A29LegOrden[0] ;
         AV10LegOrden = A29LegOrden ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV10LegOrden = (short)(AV10LegOrden+1) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = obtnroordenlegfamilia.this.AV10LegOrden;
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
      P001I2_A3CliCod = new int[1] ;
      P001I2_A1EmpCod = new short[1] ;
      P001I2_A6LegNumero = new int[1] ;
      P001I2_A29LegOrden = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obtnroordenlegfamilia__default(),
         new Object[] {
             new Object[] {
            P001I2_A3CliCod, P001I2_A1EmpCod, P001I2_A6LegNumero, P001I2_A29LegOrden
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short AV10LegOrden ;
   private short A1EmpCod ;
   private short A29LegOrden ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private String scmdbuf ;
   private short[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P001I2_A3CliCod ;
   private short[] P001I2_A1EmpCod ;
   private int[] P001I2_A6LegNumero ;
   private short[] P001I2_A29LegOrden ;
}

final  class obtnroordenlegfamilia__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P001I2", "SELECT CliCod, EmpCod, LegNumero, LegOrden FROM LegajoFamilia WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero, LegOrden DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[3])[0] = rslt.getShort(4);
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

