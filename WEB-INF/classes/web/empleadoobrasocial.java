package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empleadoobrasocial extends GXProcedure
{
   public empleadoobrasocial( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empleadoobrasocial.class ), "" );
   }

   public empleadoobrasocial( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 )
   {
      empleadoobrasocial.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             String[] aP4 )
   {
      empleadoobrasocial.this.AV9CliCod = aP0;
      empleadoobrasocial.this.AV10empcod = aP1;
      empleadoobrasocial.this.AV8LegNumero = aP2;
      empleadoobrasocial.this.AV11OsoCod = aP3;
      empleadoobrasocial.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV15GXLvl2 = (byte)(0) ;
      /* Using cursor P00IS2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10empcod), Integer.valueOf(AV8LegNumero), AV11OsoCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1580LegOsoCod = P00IS2_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P00IS2_n1580LegOsoCod[0] ;
         A6LegNumero = P00IS2_A6LegNumero[0] ;
         A1EmpCod = P00IS2_A1EmpCod[0] ;
         A3CliCod = P00IS2_A3CliCod[0] ;
         AV15GXLvl2 = (byte)(1) ;
         AV12tiene = "1" ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV15GXLvl2 == 0 )
      {
         AV12tiene = "0" ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = empleadoobrasocial.this.AV12tiene;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12tiene = "" ;
      scmdbuf = "" ;
      P00IS2_A1580LegOsoCod = new String[] {""} ;
      P00IS2_n1580LegOsoCod = new boolean[] {false} ;
      P00IS2_A6LegNumero = new int[1] ;
      P00IS2_A1EmpCod = new short[1] ;
      P00IS2_A3CliCod = new int[1] ;
      A1580LegOsoCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empleadoobrasocial__default(),
         new Object[] {
             new Object[] {
            P00IS2_A1580LegOsoCod, P00IS2_n1580LegOsoCod, P00IS2_A6LegNumero, P00IS2_A1EmpCod, P00IS2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV15GXLvl2 ;
   private short AV10empcod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV11OsoCod ;
   private String AV12tiene ;
   private String scmdbuf ;
   private String A1580LegOsoCod ;
   private boolean n1580LegOsoCod ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P00IS2_A1580LegOsoCod ;
   private boolean[] P00IS2_n1580LegOsoCod ;
   private int[] P00IS2_A6LegNumero ;
   private short[] P00IS2_A1EmpCod ;
   private int[] P00IS2_A3CliCod ;
}

final  class empleadoobrasocial__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00IS2", "SELECT LegOsoCod, LegNumero, EmpCod, CliCod FROM Legajo WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (LegOsoCod = ( ?)) ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
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
               stmt.setString(4, (String)parms[3], 20);
               return;
      }
   }

}

