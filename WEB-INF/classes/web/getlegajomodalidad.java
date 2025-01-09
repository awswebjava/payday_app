package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlegajomodalidad extends GXProcedure
{
   public getlegajomodalidad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlegajomodalidad.class ), "" );
   }

   public getlegajomodalidad( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      getlegajomodalidad.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 )
   {
      getlegajomodalidad.this.AV11CliCod = aP0;
      getlegajomodalidad.this.AV10EmpCod = aP1;
      getlegajomodalidad.this.AV9LegNumero = aP2;
      getlegajomodalidad.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P014R2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV9LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P014R2_A6LegNumero[0] ;
         A1EmpCod = P014R2_A1EmpCod[0] ;
         A3CliCod = P014R2_A3CliCod[0] ;
         A18MprCod = P014R2_A18MprCod[0] ;
         n18MprCod = P014R2_n18MprCod[0] ;
         AV8MprCod = A18MprCod ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getlegajomodalidad.this.AV8MprCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8MprCod = "" ;
      scmdbuf = "" ;
      P014R2_A6LegNumero = new int[1] ;
      P014R2_A1EmpCod = new short[1] ;
      P014R2_A3CliCod = new int[1] ;
      P014R2_A18MprCod = new String[] {""} ;
      P014R2_n18MprCod = new boolean[] {false} ;
      A18MprCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlegajomodalidad__default(),
         new Object[] {
             new Object[] {
            P014R2_A6LegNumero, P014R2_A1EmpCod, P014R2_A3CliCod, P014R2_A18MprCod, P014R2_n18MprCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV8MprCod ;
   private String scmdbuf ;
   private String A18MprCod ;
   private boolean n18MprCod ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P014R2_A6LegNumero ;
   private short[] P014R2_A1EmpCod ;
   private int[] P014R2_A3CliCod ;
   private String[] P014R2_A18MprCod ;
   private boolean[] P014R2_n18MprCod ;
}

final  class getlegajomodalidad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P014R2", "SELECT LegNumero, EmpCod, CliCod, MprCod FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
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

