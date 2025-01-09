package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class convenioparticularidadunicaes extends GXProcedure
{
   public convenioparticularidadunicaes( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenioparticularidadunicaes.class ), "" );
   }

   public convenioparticularidadunicaes( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              String aP2 )
   {
      convenioparticularidadunicaes.this.aP3 = new boolean[] {false};
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
      convenioparticularidadunicaes.this.AV10CliCod = aP0;
      convenioparticularidadunicaes.this.AV11CliPaiConve = aP1;
      convenioparticularidadunicaes.this.AV12CliConvenio = aP2;
      convenioparticularidadunicaes.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9unicaEs = true ;
      /* Using cursor P01WP2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11CliPaiConve), AV12CliConvenio});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1565CliConvenio = P01WP2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01WP2_A1564CliPaiConve[0] ;
         A3CliCod = P01WP2_A3CliCod[0] ;
         A1575CliConveVig = P01WP2_A1575CliConveVig[0] ;
         AV8i = (short)(AV8i+1) ;
         if ( AV8i == 2 )
         {
            AV9unicaEs = false ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = convenioparticularidadunicaes.this.AV9unicaEs;
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
      P01WP2_A1565CliConvenio = new String[] {""} ;
      P01WP2_A1564CliPaiConve = new short[1] ;
      P01WP2_A3CliCod = new int[1] ;
      P01WP2_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      A1565CliConvenio = "" ;
      A1575CliConveVig = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenioparticularidadunicaes__default(),
         new Object[] {
             new Object[] {
            P01WP2_A1565CliConvenio, P01WP2_A1564CliPaiConve, P01WP2_A3CliCod, P01WP2_A1575CliConveVig
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11CliPaiConve ;
   private short A1564CliPaiConve ;
   private short AV8i ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String AV12CliConvenio ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private java.util.Date A1575CliConveVig ;
   private boolean AV9unicaEs ;
   private boolean[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P01WP2_A1565CliConvenio ;
   private short[] P01WP2_A1564CliPaiConve ;
   private int[] P01WP2_A3CliCod ;
   private java.util.Date[] P01WP2_A1575CliConveVig ;
}

final  class convenioparticularidadunicaes__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01WP2", "SELECT CliConvenio, CliPaiConve, CliCod, CliConveVig FROM ClienteConvenio_Particularidades WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
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

