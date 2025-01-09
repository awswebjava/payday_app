package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlegnumeroynomporid extends GXProcedure
{
   public getlegnumeroynomporid( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlegnumeroynomporid.class ), "" );
   }

   public getlegnumeroynomporid( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             int[] aP3 )
   {
      getlegnumeroynomporid.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        int[] aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             int[] aP3 ,
                             String[] aP4 )
   {
      getlegnumeroynomporid.this.AV8CliCod = aP0;
      getlegnumeroynomporid.this.AV9EmpCod = aP1;
      getlegnumeroynomporid.this.AV10LegId = aP2;
      getlegnumeroynomporid.this.aP3 = aP3;
      getlegnumeroynomporid.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00292 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), AV10LegId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A93LegId = P00292_A93LegId[0] ;
         n93LegId = P00292_n93LegId[0] ;
         A1EmpCod = P00292_A1EmpCod[0] ;
         A3CliCod = P00292_A3CliCod[0] ;
         A6LegNumero = P00292_A6LegNumero[0] ;
         A250LegIdNomApe = P00292_A250LegIdNomApe[0] ;
         AV11LegNumero = A6LegNumero ;
         AV12LegNomApe = A250LegIdNomApe ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getlegnumeroynomporid.this.AV11LegNumero;
      this.aP4[0] = getlegnumeroynomporid.this.AV12LegNomApe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12LegNomApe = "" ;
      scmdbuf = "" ;
      P00292_A93LegId = new String[] {""} ;
      P00292_n93LegId = new boolean[] {false} ;
      P00292_A1EmpCod = new short[1] ;
      P00292_A3CliCod = new int[1] ;
      P00292_A6LegNumero = new int[1] ;
      P00292_A250LegIdNomApe = new String[] {""} ;
      A93LegId = "" ;
      A250LegIdNomApe = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlegnumeroynomporid__default(),
         new Object[] {
             new Object[] {
            P00292_A93LegId, P00292_n93LegId, P00292_A1EmpCod, P00292_A3CliCod, P00292_A6LegNumero, P00292_A250LegIdNomApe
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV11LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private String AV10LegId ;
   private String scmdbuf ;
   private String A93LegId ;
   private boolean n93LegId ;
   private String AV12LegNomApe ;
   private String A250LegIdNomApe ;
   private String[] aP4 ;
   private int[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P00292_A93LegId ;
   private boolean[] P00292_n93LegId ;
   private short[] P00292_A1EmpCod ;
   private int[] P00292_A3CliCod ;
   private int[] P00292_A6LegNumero ;
   private String[] P00292_A250LegIdNomApe ;
}

final  class getlegnumeroynomporid__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00292", "SELECT LegId, EmpCod, CliCod, LegNumero, LegIdNomApe FROM Legajo WHERE (CliCod = ? and EmpCod = ?) AND (LegId = ( ?)) ORDER BY CliCod, EmpCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
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
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

