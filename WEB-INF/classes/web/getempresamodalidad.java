package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getempresamodalidad extends GXProcedure
{
   public getempresamodalidad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getempresamodalidad.class ), "" );
   }

   public getempresamodalidad( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              String[] aP2 )
   {
      getempresamodalidad.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String[] aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String[] aP2 ,
                             boolean[] aP3 )
   {
      getempresamodalidad.this.AV8CliCod = aP0;
      getempresamodalidad.this.AV9EmpCod = aP1;
      getempresamodalidad.this.aP2 = aP2;
      getempresamodalidad.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02KY2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P02KY2_A1EmpCod[0] ;
         A3CliCod = P02KY2_A3CliCod[0] ;
         A2405EmpModTra = P02KY2_A2405EmpModTra[0] ;
         A2406EmpModEmpl = P02KY2_A2406EmpModEmpl[0] ;
         A2407EmpModAuto = P02KY2_A2407EmpModAuto[0] ;
         AV11EmpModTra = A2405EmpModTra ;
         if ( ( ( A2407EmpModAuto ) && ! A2406EmpModEmpl ) || ( ! A2407EmpModAuto && ( A2406EmpModEmpl ) ) )
         {
            AV13unicaEs = true ;
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getempresamodalidad.this.AV11EmpModTra;
      this.aP3[0] = getempresamodalidad.this.AV13unicaEs;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11EmpModTra = "" ;
      scmdbuf = "" ;
      P02KY2_A1EmpCod = new short[1] ;
      P02KY2_A3CliCod = new int[1] ;
      P02KY2_A2405EmpModTra = new String[] {""} ;
      P02KY2_A2406EmpModEmpl = new boolean[] {false} ;
      P02KY2_A2407EmpModAuto = new boolean[] {false} ;
      A2405EmpModTra = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getempresamodalidad__default(),
         new Object[] {
             new Object[] {
            P02KY2_A1EmpCod, P02KY2_A3CliCod, P02KY2_A2405EmpModTra, P02KY2_A2406EmpModEmpl, P02KY2_A2407EmpModAuto
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
   private int A3CliCod ;
   private String AV11EmpModTra ;
   private String scmdbuf ;
   private String A2405EmpModTra ;
   private boolean AV13unicaEs ;
   private boolean A2406EmpModEmpl ;
   private boolean A2407EmpModAuto ;
   private boolean[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P02KY2_A1EmpCod ;
   private int[] P02KY2_A3CliCod ;
   private String[] P02KY2_A2405EmpModTra ;
   private boolean[] P02KY2_A2406EmpModEmpl ;
   private boolean[] P02KY2_A2407EmpModAuto ;
}

final  class getempresamodalidad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02KY2", "SELECT EmpCod, CliCod, EmpModTra, EmpModEmpl, EmpModAuto FROM Empresa WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
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
               return;
      }
   }

}

