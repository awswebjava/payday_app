package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ultimaversiondeconvenio extends GXProcedure
{
   public ultimaversiondeconvenio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ultimaversiondeconvenio.class ), "" );
   }

   public ultimaversiondeconvenio( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( short aP0 ,
                          String aP1 )
   {
      ultimaversiondeconvenio.this.aP2 = new int[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        int[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             int[] aP2 )
   {
      ultimaversiondeconvenio.this.AV10CliPaiConve = aP0;
      ultimaversiondeconvenio.this.AV11CliConvenio = aP1;
      ultimaversiondeconvenio.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "&CliPaiConve", "")+GXutil.trim( GXutil.str( AV10CliPaiConve, 4, 0))+httpContext.getMessage( " &CliConvenio ", "")+AV11CliConvenio) ;
      /* Using cursor P01FS2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV10CliPaiConve), AV11CliConvenio});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1566CliConveVer = P01FS2_A1566CliConveVer[0] ;
         n1566CliConveVer = P01FS2_n1566CliConveVer[0] ;
         A1565CliConvenio = P01FS2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01FS2_A1564CliPaiConve[0] ;
         A3CliCod = P01FS2_A3CliCod[0] ;
         AV9CliCod = A3CliCod ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "encuentra ", "")+GXutil.trim( GXutil.str( AV9CliCod, 6, 0))) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = ultimaversiondeconvenio.this.AV9CliCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14Pgmname = "" ;
      scmdbuf = "" ;
      P01FS2_A1566CliConveVer = new int[1] ;
      P01FS2_n1566CliConveVer = new boolean[] {false} ;
      P01FS2_A1565CliConvenio = new String[] {""} ;
      P01FS2_A1564CliPaiConve = new short[1] ;
      P01FS2_A3CliCod = new int[1] ;
      A1565CliConvenio = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.ultimaversiondeconvenio__default(),
         new Object[] {
             new Object[] {
            P01FS2_A1566CliConveVer, P01FS2_n1566CliConveVer, P01FS2_A1565CliConvenio, P01FS2_A1564CliPaiConve, P01FS2_A3CliCod
            }
         }
      );
      AV14Pgmname = "ultimaVersionDeConvenio" ;
      /* GeneXus formulas. */
      AV14Pgmname = "ultimaVersionDeConvenio" ;
      Gx_err = (short)(0) ;
   }

   private short AV10CliPaiConve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int A1566CliConveVer ;
   private int A3CliCod ;
   private String AV11CliConvenio ;
   private String AV14Pgmname ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private boolean n1566CliConveVer ;
   private int[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P01FS2_A1566CliConveVer ;
   private boolean[] P01FS2_n1566CliConveVer ;
   private String[] P01FS2_A1565CliConvenio ;
   private short[] P01FS2_A1564CliPaiConve ;
   private int[] P01FS2_A3CliCod ;
}

final  class ultimaversiondeconvenio__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01FS2", "SELECT CliConveVer, CliConvenio, CliPaiConve, CliCod FROM ClienteConvenios WHERE (CliConveVer IS NULL) AND (CliPaiConve = ?) AND (CliConvenio = ( ?)) ORDER BY CliCod DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

