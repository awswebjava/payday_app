package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlegnumeroynomidporcuil extends GXProcedure
{
   public getlegnumeroynomidporcuil( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlegnumeroynomidporcuil.class ), "" );
   }

   public getlegnumeroynomidporcuil( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             long aP2 ,
                             int[] aP3 )
   {
      getlegnumeroynomidporcuil.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        long aP2 ,
                        int[] aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             long aP2 ,
                             int[] aP3 ,
                             String[] aP4 )
   {
      getlegnumeroynomidporcuil.this.AV8CliCod = aP0;
      getlegnumeroynomidporcuil.this.AV9EmpCod = aP1;
      getlegnumeroynomidporcuil.this.AV10LegCUIL = aP2;
      getlegnumeroynomidporcuil.this.aP3 = aP3;
      getlegnumeroynomidporcuil.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P002A2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Long.valueOf(AV10LegCUIL)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A239LegCUIL = P002A2_A239LegCUIL[0] ;
         A1EmpCod = P002A2_A1EmpCod[0] ;
         A3CliCod = P002A2_A3CliCod[0] ;
         A6LegNumero = P002A2_A6LegNumero[0] ;
         A250LegIdNomApe = P002A2_A250LegIdNomApe[0] ;
         AV11LegNumero = A6LegNumero ;
         AV12LegIdNomApe = A250LegIdNomApe ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getlegnumeroynomidporcuil.this.AV11LegNumero;
      this.aP4[0] = getlegnumeroynomidporcuil.this.AV12LegIdNomApe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12LegIdNomApe = "" ;
      scmdbuf = "" ;
      P002A2_A239LegCUIL = new long[1] ;
      P002A2_A1EmpCod = new short[1] ;
      P002A2_A3CliCod = new int[1] ;
      P002A2_A6LegNumero = new int[1] ;
      P002A2_A250LegIdNomApe = new String[] {""} ;
      A250LegIdNomApe = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlegnumeroynomidporcuil__default(),
         new Object[] {
             new Object[] {
            P002A2_A239LegCUIL, P002A2_A1EmpCod, P002A2_A3CliCod, P002A2_A6LegNumero, P002A2_A250LegIdNomApe
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
   private long AV10LegCUIL ;
   private long A239LegCUIL ;
   private String scmdbuf ;
   private String AV12LegIdNomApe ;
   private String A250LegIdNomApe ;
   private String[] aP4 ;
   private int[] aP3 ;
   private IDataStoreProvider pr_default ;
   private long[] P002A2_A239LegCUIL ;
   private short[] P002A2_A1EmpCod ;
   private int[] P002A2_A3CliCod ;
   private int[] P002A2_A6LegNumero ;
   private String[] P002A2_A250LegIdNomApe ;
}

final  class getlegnumeroynomidporcuil__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002A2", "SELECT LegCUIL, EmpCod, CliCod, LegNumero, LegIdNomApe FROM Legajo WHERE (CliCod = ? and EmpCod = ?) AND (LegCUIL = ?) ORDER BY CliCod, EmpCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
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
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
      }
   }

}

