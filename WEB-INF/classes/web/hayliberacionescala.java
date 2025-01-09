package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class hayliberacionescala extends GXProcedure
{
   public hayliberacionescala( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( hayliberacionescala.class ), "" );
   }

   public hayliberacionescala( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              int aP1 )
   {
      hayliberacionescala.this.aP2 = new boolean[] {false};
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
      hayliberacionescala.this.AV8CliCod = aP0;
      hayliberacionescala.this.AV9CliRelSec = aP1;
      hayliberacionescala.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01VO2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Integer.valueOf(AV9CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1891CatSalRelSec = P01VO2_A1891CatSalRelSec[0] ;
         n1891CatSalRelSec = P01VO2_n1891CatSalRelSec[0] ;
         A3CliCod = P01VO2_A3CliCod[0] ;
         A1564CliPaiConve = P01VO2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01VO2_A1565CliConvenio[0] ;
         A8CatCodigo = P01VO2_A8CatCodigo[0] ;
         A907CatVigencia = P01VO2_A907CatVigencia[0] ;
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
      this.aP2[0] = hayliberacionescala.this.AV10hay;
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
      P01VO2_A1891CatSalRelSec = new int[1] ;
      P01VO2_n1891CatSalRelSec = new boolean[] {false} ;
      P01VO2_A3CliCod = new int[1] ;
      P01VO2_A1564CliPaiConve = new short[1] ;
      P01VO2_A1565CliConvenio = new String[] {""} ;
      P01VO2_A8CatCodigo = new String[] {""} ;
      P01VO2_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      A1565CliConvenio = "" ;
      A8CatCodigo = "" ;
      A907CatVigencia = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.hayliberacionescala__default(),
         new Object[] {
             new Object[] {
            P01VO2_A1891CatSalRelSec, P01VO2_n1891CatSalRelSec, P01VO2_A3CliCod, P01VO2_A1564CliPaiConve, P01VO2_A1565CliConvenio, P01VO2_A8CatCodigo, P01VO2_A907CatVigencia
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV9CliRelSec ;
   private int A1891CatSalRelSec ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A8CatCodigo ;
   private java.util.Date A907CatVigencia ;
   private boolean AV10hay ;
   private boolean n1891CatSalRelSec ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P01VO2_A1891CatSalRelSec ;
   private boolean[] P01VO2_n1891CatSalRelSec ;
   private int[] P01VO2_A3CliCod ;
   private short[] P01VO2_A1564CliPaiConve ;
   private String[] P01VO2_A1565CliConvenio ;
   private String[] P01VO2_A8CatCodigo ;
   private java.util.Date[] P01VO2_A907CatVigencia ;
}

final  class hayliberacionescala__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01VO2", "SELECT CatSalRelSec, CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia FROM Categoriavalores1 WHERE (CliCod = ?) AND (CatSalRelSec = ?) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((String[]) buf[5])[0] = rslt.getString(5, 40);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(6);
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

