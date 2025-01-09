package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empleadoseccion extends GXProcedure
{
   public empleadoseccion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empleadoseccion.class ), "" );
   }

   public empleadoseccion( int remoteHandle ,
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
      empleadoseccion.this.aP4 = new String[] {""};
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
      empleadoseccion.this.AV12CliCod = aP0;
      empleadoseccion.this.AV13empcod = aP1;
      empleadoseccion.this.AV8LegNumero = aP2;
      empleadoseccion.this.AV11SecCodigo = aP3;
      empleadoseccion.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV16GXLvl2 = (byte)(0) ;
      /* Using cursor P004X2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV13empcod), Integer.valueOf(AV8LegNumero), AV11SecCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1579LegSecCodigo = P004X2_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P004X2_n1579LegSecCodigo[0] ;
         A6LegNumero = P004X2_A6LegNumero[0] ;
         A1EmpCod = P004X2_A1EmpCod[0] ;
         A3CliCod = P004X2_A3CliCod[0] ;
         AV16GXLvl2 = (byte)(1) ;
         AV10tiene = "1" ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV16GXLvl2 == 0 )
      {
         AV10tiene = "0" ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = empleadoseccion.this.AV10tiene;
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
      P004X2_A1579LegSecCodigo = new String[] {""} ;
      P004X2_n1579LegSecCodigo = new boolean[] {false} ;
      P004X2_A6LegNumero = new int[1] ;
      P004X2_A1EmpCod = new short[1] ;
      P004X2_A3CliCod = new int[1] ;
      A1579LegSecCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empleadoseccion__default(),
         new Object[] {
             new Object[] {
            P004X2_A1579LegSecCodigo, P004X2_n1579LegSecCodigo, P004X2_A6LegNumero, P004X2_A1EmpCod, P004X2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV16GXLvl2 ;
   private short AV13empcod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV11SecCodigo ;
   private String AV10tiene ;
   private String scmdbuf ;
   private String A1579LegSecCodigo ;
   private boolean n1579LegSecCodigo ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P004X2_A1579LegSecCodigo ;
   private boolean[] P004X2_n1579LegSecCodigo ;
   private int[] P004X2_A6LegNumero ;
   private short[] P004X2_A1EmpCod ;
   private int[] P004X2_A3CliCod ;
}

final  class empleadoseccion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004X2", "SELECT LegSecCodigo, LegNumero, EmpCod, CliCod FROM Legajo WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (LegSecCodigo = ( ?)) ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

