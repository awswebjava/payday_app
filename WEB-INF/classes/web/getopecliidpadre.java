package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getopecliidpadre extends GXProcedure
{
   public getopecliidpadre( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getopecliidpadre.class ), "" );
   }

   public getopecliidpadre( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 )
   {
      getopecliidpadre.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      getopecliidpadre.this.AV8CliCod = aP0;
      getopecliidpadre.this.AV9OpeCliId = aP1;
      getopecliidpadre.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01XL2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9OpeCliId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A82OpeCliId = P01XL2_A82OpeCliId[0] ;
         A3CliCod = P01XL2_A3CliCod[0] ;
         A1906OpeCliIdPadre = P01XL2_A1906OpeCliIdPadre[0] ;
         AV10OpeCliIdPadre = A1906OpeCliIdPadre ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getopecliidpadre.this.AV10OpeCliIdPadre;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10OpeCliIdPadre = "" ;
      scmdbuf = "" ;
      P01XL2_A82OpeCliId = new String[] {""} ;
      P01XL2_A3CliCod = new int[1] ;
      P01XL2_A1906OpeCliIdPadre = new String[] {""} ;
      A82OpeCliId = "" ;
      A1906OpeCliIdPadre = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getopecliidpadre__default(),
         new Object[] {
             new Object[] {
            P01XL2_A82OpeCliId, P01XL2_A3CliCod, P01XL2_A1906OpeCliIdPadre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9OpeCliId ;
   private String AV10OpeCliIdPadre ;
   private String scmdbuf ;
   private String A82OpeCliId ;
   private String A1906OpeCliIdPadre ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01XL2_A82OpeCliId ;
   private int[] P01XL2_A3CliCod ;
   private String[] P01XL2_A1906OpeCliIdPadre ;
}

final  class getopecliidpadre__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01XL2", "SELECT OpeCliId, CliCod, OpeCliIdPadre FROM Variable WHERE CliCod = ? and OpeCliId = ( ?) ORDER BY CliCod, OpeCliId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
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
               stmt.setString(2, (String)parms[1], 40);
               return;
      }
   }

}

