package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class condicioniiggexiste extends GXProcedure
{
   public condicioniiggexiste( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( condicioniiggexiste.class ), "" );
   }

   public condicioniiggexiste( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 )
   {
      condicioniiggexiste.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             boolean[] aP2 )
   {
      condicioniiggexiste.this.AV9CliCod = aP0;
      condicioniiggexiste.this.AV10CondExenIIGG = aP1;
      condicioniiggexiste.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01FQ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), AV10CondExenIIGG});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1105CondExenIIGG = P01FQ2_A1105CondExenIIGG[0] ;
         A3CliCod = P01FQ2_A3CliCod[0] ;
         AV8existe = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = condicioniiggexiste.this.AV8existe;
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
      P01FQ2_A1105CondExenIIGG = new String[] {""} ;
      P01FQ2_A3CliCod = new int[1] ;
      A1105CondExenIIGG = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.condicioniiggexiste__default(),
         new Object[] {
             new Object[] {
            P01FQ2_A1105CondExenIIGG, P01FQ2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private String AV10CondExenIIGG ;
   private String scmdbuf ;
   private String A1105CondExenIIGG ;
   private boolean AV8existe ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01FQ2_A1105CondExenIIGG ;
   private int[] P01FQ2_A3CliCod ;
}

final  class condicioniiggexiste__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01FQ2", "SELECT CondExenIIGG, CliCod FROM condicion_exencion_iigg WHERE CliCod = ? and CondExenIIGG = ( ?) ORDER BY CliCod, CondExenIIGG ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
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
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

