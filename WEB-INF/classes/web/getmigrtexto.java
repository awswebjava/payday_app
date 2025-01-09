package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmigrtexto extends GXProcedure
{
   public getmigrtexto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmigrtexto.class ), "" );
   }

   public getmigrtexto( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 )
   {
      getmigrtexto.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String[] aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 ,
                             String[] aP4 )
   {
      getmigrtexto.this.AV12CliCod = aP0;
      getmigrtexto.this.AV8EmpCod = aP1;
      getmigrtexto.this.AV11MigrLegNumero = aP2;
      getmigrtexto.this.aP3 = aP3;
      getmigrtexto.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00MO2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV11MigrLegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A87MigrLegNumero = P00MO2_A87MigrLegNumero[0] ;
         A1EmpCod = P00MO2_A1EmpCod[0] ;
         A3CliCod = P00MO2_A3CliCod[0] ;
         A629MigrLegErrores = P00MO2_A629MigrLegErrores[0] ;
         A633MigrLegWarnings = P00MO2_A633MigrLegWarnings[0] ;
         AV9MigrLegErrores = httpContext.getMessage( "<span style=\"color: red;\">", "") + GXutil.trim( A629MigrLegErrores) + httpContext.getMessage( "</span>", "") ;
         AV10MigrLegWarnings = A633MigrLegWarnings ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getmigrtexto.this.AV9MigrLegErrores;
      this.aP4[0] = getmigrtexto.this.AV10MigrLegWarnings;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9MigrLegErrores = "" ;
      AV10MigrLegWarnings = "" ;
      scmdbuf = "" ;
      P00MO2_A87MigrLegNumero = new int[1] ;
      P00MO2_A1EmpCod = new short[1] ;
      P00MO2_A3CliCod = new int[1] ;
      P00MO2_A629MigrLegErrores = new String[] {""} ;
      P00MO2_A633MigrLegWarnings = new String[] {""} ;
      A629MigrLegErrores = "" ;
      A633MigrLegWarnings = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getmigrtexto__default(),
         new Object[] {
             new Object[] {
            P00MO2_A87MigrLegNumero, P00MO2_A1EmpCod, P00MO2_A3CliCod, P00MO2_A629MigrLegErrores, P00MO2_A633MigrLegWarnings
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV11MigrLegNumero ;
   private int A87MigrLegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String AV9MigrLegErrores ;
   private String AV10MigrLegWarnings ;
   private String A629MigrLegErrores ;
   private String A633MigrLegWarnings ;
   private String[] aP4 ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P00MO2_A87MigrLegNumero ;
   private short[] P00MO2_A1EmpCod ;
   private int[] P00MO2_A3CliCod ;
   private String[] P00MO2_A629MigrLegErrores ;
   private String[] P00MO2_A633MigrLegWarnings ;
}

final  class getmigrtexto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00MO2", "SELECT MigrLegNumero, EmpCod, CliCod, MigrLegErrores, MigrLegWarnings FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? ORDER BY CliCod, EmpCod, MigrLegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
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

