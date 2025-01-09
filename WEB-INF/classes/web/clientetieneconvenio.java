package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class clientetieneconvenio extends GXProcedure
{
   public clientetieneconvenio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clientetieneconvenio.class ), "" );
   }

   public clientetieneconvenio( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              String aP2 )
   {
      clientetieneconvenio.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             boolean[] aP3 )
   {
      clientetieneconvenio.this.AV8CliCod = aP0;
      clientetieneconvenio.this.AV10CliPaiConve = aP1;
      clientetieneconvenio.this.AV9CliConvenio = aP2;
      clientetieneconvenio.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01FU2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV10CliPaiConve), AV9CliConvenio});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1565CliConvenio = P01FU2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01FU2_A1564CliPaiConve[0] ;
         A3CliCod = P01FU2_A3CliCod[0] ;
         AV11tiene = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = clientetieneconvenio.this.AV11tiene;
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
      P01FU2_A1565CliConvenio = new String[] {""} ;
      P01FU2_A1564CliPaiConve = new short[1] ;
      P01FU2_A3CliCod = new int[1] ;
      A1565CliConvenio = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.clientetieneconvenio__default(),
         new Object[] {
             new Object[] {
            P01FU2_A1565CliConvenio, P01FU2_A1564CliPaiConve, P01FU2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10CliPaiConve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9CliConvenio ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private boolean AV11tiene ;
   private boolean[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P01FU2_A1565CliConvenio ;
   private short[] P01FU2_A1564CliPaiConve ;
   private int[] P01FU2_A3CliCod ;
}

final  class clientetieneconvenio__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01FU2", "SELECT CliConvenio, CliPaiConve, CliCod FROM ClienteConvenios WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
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
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

