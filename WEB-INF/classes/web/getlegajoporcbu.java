package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlegajoporcbu extends GXProcedure
{
   public getlegajoporcbu( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlegajoporcbu.class ), "" );
   }

   public getlegajoporcbu( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 ,
                          short aP1 ,
                          int aP2 ,
                          String aP3 )
   {
      getlegajoporcbu.this.aP4 = new int[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        int[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             int[] aP4 )
   {
      getlegajoporcbu.this.AV12CliCod = aP0;
      getlegajoporcbu.this.AV11EmpCod = aP1;
      getlegajoporcbu.this.AV9LegNumero = aP2;
      getlegajoporcbu.this.AV8LegCBU = aP3;
      getlegajoporcbu.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01N02 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV9LegNumero), AV8LegCBU});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P01N02_A6LegNumero[0] ;
         A234LegCBU = P01N02_A234LegCBU[0] ;
         n234LegCBU = P01N02_n234LegCBU[0] ;
         A1EmpCod = P01N02_A1EmpCod[0] ;
         A3CliCod = P01N02_A3CliCod[0] ;
         AV10cbuLegNumero = A6LegNumero ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getlegajoporcbu.this.AV10cbuLegNumero;
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
      P01N02_A6LegNumero = new int[1] ;
      P01N02_A234LegCBU = new String[] {""} ;
      P01N02_n234LegCBU = new boolean[] {false} ;
      P01N02_A1EmpCod = new short[1] ;
      P01N02_A3CliCod = new int[1] ;
      A234LegCBU = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlegajoporcbu__default(),
         new Object[] {
             new Object[] {
            P01N02_A6LegNumero, P01N02_A234LegCBU, P01N02_n234LegCBU, P01N02_A1EmpCod, P01N02_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV9LegNumero ;
   private int AV10cbuLegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean n234LegCBU ;
   private String AV8LegCBU ;
   private String A234LegCBU ;
   private int[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P01N02_A6LegNumero ;
   private String[] P01N02_A234LegCBU ;
   private boolean[] P01N02_n234LegCBU ;
   private short[] P01N02_A1EmpCod ;
   private int[] P01N02_A3CliCod ;
}

final  class getlegajoporcbu__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01N02", "SELECT LegNumero, LegCBU, EmpCod, CliCod FROM Legajo WHERE (CliCod = ? and EmpCod = ?) AND (LegNumero <> ?) AND (LegCBU = ( ?)) ORDER BY CliCod, EmpCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
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
               stmt.setVarchar(4, (String)parms[3], 22);
               return;
      }
   }

}

