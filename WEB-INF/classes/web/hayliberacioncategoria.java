package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class hayliberacioncategoria extends GXProcedure
{
   public hayliberacioncategoria( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( hayliberacioncategoria.class ), "" );
   }

   public hayliberacioncategoria( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              int aP1 )
   {
      hayliberacioncategoria.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        int aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             int aP1 ,
                             boolean[] aP2 )
   {
      hayliberacioncategoria.this.AV8CliCod = aP0;
      hayliberacioncategoria.this.AV9CliRelSec = aP1;
      hayliberacioncategoria.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01VM2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Integer.valueOf(AV9CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1894CatRelSec = P01VM2_A1894CatRelSec[0] ;
         n1894CatRelSec = P01VM2_n1894CatRelSec[0] ;
         A3CliCod = P01VM2_A3CliCod[0] ;
         A1564CliPaiConve = P01VM2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01VM2_A1565CliConvenio[0] ;
         A8CatCodigo = P01VM2_A8CatCodigo[0] ;
         AV10hay = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = hayliberacioncategoria.this.AV10hay;
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
      P01VM2_A1894CatRelSec = new short[1] ;
      P01VM2_n1894CatRelSec = new boolean[] {false} ;
      P01VM2_A3CliCod = new int[1] ;
      P01VM2_A1564CliPaiConve = new short[1] ;
      P01VM2_A1565CliConvenio = new String[] {""} ;
      P01VM2_A8CatCodigo = new String[] {""} ;
      A1565CliConvenio = "" ;
      A8CatCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.hayliberacioncategoria__default(),
         new Object[] {
             new Object[] {
            P01VM2_A1894CatRelSec, P01VM2_n1894CatRelSec, P01VM2_A3CliCod, P01VM2_A1564CliPaiConve, P01VM2_A1565CliConvenio, P01VM2_A8CatCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A1894CatRelSec ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV9CliRelSec ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A8CatCodigo ;
   private boolean AV10hay ;
   private boolean n1894CatRelSec ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P01VM2_A1894CatRelSec ;
   private boolean[] P01VM2_n1894CatRelSec ;
   private int[] P01VM2_A3CliCod ;
   private short[] P01VM2_A1564CliPaiConve ;
   private String[] P01VM2_A1565CliConvenio ;
   private String[] P01VM2_A8CatCodigo ;
}

final  class hayliberacioncategoria__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01VM2", "SELECT CatRelSec, CliCod, CliPaiConve, CliConvenio, CatCodigo FROM Categoria1 WHERE (CliCod = ?) AND (CatRelSec = ?) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((String[]) buf[5])[0] = rslt.getString(5, 40);
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
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
      }
   }

}

