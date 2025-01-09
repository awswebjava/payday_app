package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getulticonveimpvig extends GXProcedure
{
   public getulticonveimpvig( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getulticonveimpvig.class ), "" );
   }

   public getulticonveimpvig( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     short aP1 ,
                                     String aP2 )
   {
      getulticonveimpvig.this.aP3 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        java.util.Date[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             java.util.Date[] aP3 )
   {
      getulticonveimpvig.this.AV8clicod = aP0;
      getulticonveimpvig.this.AV11clipaiconve = aP1;
      getulticonveimpvig.this.AV10cliconvenio = aP2;
      getulticonveimpvig.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01XD2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8clicod), Short.valueOf(AV11clipaiconve), AV10cliconvenio});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01XD2_A3CliCod[0] ;
         A1564CliPaiConve = P01XD2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01XD2_A1565CliConvenio[0] ;
         A1587CliConveImpVig = P01XD2_A1587CliConveImpVig[0] ;
         A1588CliConveImpTipo = P01XD2_A1588CliConveImpTipo[0] ;
         AV9CliConveImpVig = A1587CliConveImpVig ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getulticonveimpvig.this.AV9CliConveImpVig;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9CliConveImpVig = GXutil.nullDate() ;
      scmdbuf = "" ;
      P01XD2_A3CliCod = new int[1] ;
      P01XD2_A1564CliPaiConve = new short[1] ;
      P01XD2_A1565CliConvenio = new String[] {""} ;
      P01XD2_A1587CliConveImpVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01XD2_A1588CliConveImpTipo = new String[] {""} ;
      A1565CliConvenio = "" ;
      A1587CliConveImpVig = GXutil.nullDate() ;
      A1588CliConveImpTipo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getulticonveimpvig__default(),
         new Object[] {
             new Object[] {
            P01XD2_A3CliCod, P01XD2_A1564CliPaiConve, P01XD2_A1565CliConvenio, P01XD2_A1587CliConveImpVig, P01XD2_A1588CliConveImpTipo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11clipaiconve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV8clicod ;
   private int A3CliCod ;
   private String AV10cliconvenio ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A1588CliConveImpTipo ;
   private java.util.Date AV9CliConveImpVig ;
   private java.util.Date A1587CliConveImpVig ;
   private java.util.Date[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P01XD2_A3CliCod ;
   private short[] P01XD2_A1564CliPaiConve ;
   private String[] P01XD2_A1565CliConvenio ;
   private java.util.Date[] P01XD2_A1587CliConveImpVig ;
   private String[] P01XD2_A1588CliConveImpTipo ;
}

final  class getulticonveimpvig__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01XD2", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveImpVig, CliConveImpTipo FROM clienteConvenio_importes WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveImpVig DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
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

