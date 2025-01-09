package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empleadoclase extends GXProcedure
{
   public empleadoclase( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empleadoclase.class ), "" );
   }

   public empleadoclase( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             byte aP3 )
   {
      empleadoclase.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        byte aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             byte aP3 ,
                             String[] aP4 )
   {
      empleadoclase.this.AV11CliCod = aP0;
      empleadoclase.this.AV12empcod = aP1;
      empleadoclase.this.AV8LegNumero = aP2;
      empleadoclase.this.AV9LegClase = aP3;
      empleadoclase.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV15GXLvl2 = (byte)(0) ;
      /* Using cursor P004O2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12empcod), Integer.valueOf(AV8LegNumero), Byte.valueOf(AV9LegClase)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A235LegClase = P004O2_A235LegClase[0] ;
         A6LegNumero = P004O2_A6LegNumero[0] ;
         A1EmpCod = P004O2_A1EmpCod[0] ;
         A3CliCod = P004O2_A3CliCod[0] ;
         AV15GXLvl2 = (byte)(1) ;
         AV10tiene = "1" ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV15GXLvl2 == 0 )
      {
         AV10tiene = "0" ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = empleadoclase.this.AV10tiene;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10tiene = "" ;
      scmdbuf = "" ;
      P004O2_A235LegClase = new byte[1] ;
      P004O2_A6LegNumero = new int[1] ;
      P004O2_A1EmpCod = new short[1] ;
      P004O2_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empleadoclase__default(),
         new Object[] {
             new Object[] {
            P004O2_A235LegClase, P004O2_A6LegNumero, P004O2_A1EmpCod, P004O2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV9LegClase ;
   private byte AV15GXLvl2 ;
   private byte A235LegClase ;
   private short AV12empcod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV10tiene ;
   private String scmdbuf ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private byte[] P004O2_A235LegClase ;
   private int[] P004O2_A6LegNumero ;
   private short[] P004O2_A1EmpCod ;
   private int[] P004O2_A3CliCod ;
}

final  class empleadoclase__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004O2", "SELECT LegClase, LegNumero, EmpCod, CliCod FROM Legajo WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (LegClase = ?) ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
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
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               return;
      }
   }

}

