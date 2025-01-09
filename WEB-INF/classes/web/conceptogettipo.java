package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptogettipo extends GXProcedure
{
   public conceptogettipo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptogettipo.class ), "" );
   }

   public conceptogettipo( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 )
   {
      conceptogettipo.this.aP2 = new String[] {""};
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
      conceptogettipo.this.AV9CliCod = aP0;
      conceptogettipo.this.AV8ConCodigo = aP1;
      conceptogettipo.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P000K2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), AV8ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P000K2_A26ConCodigo[0] ;
         A3CliCod = P000K2_A3CliCod[0] ;
         A37TipoConCod = P000K2_A37TipoConCod[0] ;
         AV10TipoConCod = A37TipoConCod ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = conceptogettipo.this.AV10TipoConCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10TipoConCod = "" ;
      scmdbuf = "" ;
      P000K2_A26ConCodigo = new String[] {""} ;
      P000K2_A3CliCod = new int[1] ;
      P000K2_A37TipoConCod = new String[] {""} ;
      A26ConCodigo = "" ;
      A37TipoConCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptogettipo__default(),
         new Object[] {
             new Object[] {
            P000K2_A26ConCodigo, P000K2_A3CliCod, P000K2_A37TipoConCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private String AV8ConCodigo ;
   private String AV10TipoConCod ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A37TipoConCod ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P000K2_A26ConCodigo ;
   private int[] P000K2_A3CliCod ;
   private String[] P000K2_A37TipoConCod ;
}

final  class conceptogettipo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000K2", "SELECT ConCodigo, CliCod, TipoConCod FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
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
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
   }

}

