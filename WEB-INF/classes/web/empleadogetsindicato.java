package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empleadogetsindicato extends GXProcedure
{
   public empleadogetsindicato( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empleadogetsindicato.class ), "" );
   }

   public empleadogetsindicato( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      empleadogetsindicato.this.aP3 = new String[] {""};
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
      empleadogetsindicato.this.AV11CliCod = aP0;
      empleadogetsindicato.this.AV12empcod = aP1;
      empleadogetsindicato.this.AV8LegNumero = aP2;
      empleadogetsindicato.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00D52 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12empcod), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P00D52_A6LegNumero[0] ;
         A1EmpCod = P00D52_A1EmpCod[0] ;
         A3CliCod = P00D52_A3CliCod[0] ;
         A910LegSinCod = P00D52_A910LegSinCod[0] ;
         n910LegSinCod = P00D52_n910LegSinCod[0] ;
         AV9SinCod = A910LegSinCod ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = empleadogetsindicato.this.AV9SinCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9SinCod = "" ;
      scmdbuf = "" ;
      P00D52_A6LegNumero = new int[1] ;
      P00D52_A1EmpCod = new short[1] ;
      P00D52_A3CliCod = new int[1] ;
      P00D52_A910LegSinCod = new String[] {""} ;
      P00D52_n910LegSinCod = new boolean[] {false} ;
      A910LegSinCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empleadogetsindicato__default(),
         new Object[] {
             new Object[] {
            P00D52_A6LegNumero, P00D52_A1EmpCod, P00D52_A3CliCod, P00D52_A910LegSinCod, P00D52_n910LegSinCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12empcod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV9SinCod ;
   private String scmdbuf ;
   private String A910LegSinCod ;
   private boolean n910LegSinCod ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P00D52_A6LegNumero ;
   private short[] P00D52_A1EmpCod ;
   private int[] P00D52_A3CliCod ;
   private String[] P00D52_A910LegSinCod ;
   private boolean[] P00D52_n910LegSinCod ;
}

final  class empleadogetsindicato__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00D52", "SELECT LegNumero, EmpCod, CliCod, LegSinCod FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

