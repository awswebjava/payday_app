package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getultiadiimportevig extends GXProcedure
{
   public getultiadiimportevig( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getultiadiimportevig.class ), "" );
   }

   public getultiadiimportevig( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     short aP1 ,
                                     String aP2 ,
                                     String aP3 )
   {
      getultiadiimportevig.this.aP4 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 ,
                        java.util.Date[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 ,
                             java.util.Date[] aP4 )
   {
      getultiadiimportevig.this.AV8clicod = aP0;
      getultiadiimportevig.this.AV9clipaiconve = aP1;
      getultiadiimportevig.this.AV10cliconvenio = aP2;
      getultiadiimportevig.this.AV11ConveAdicod = aP3;
      getultiadiimportevig.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01XC2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8clicod), Short.valueOf(AV9clipaiconve), AV10cliconvenio, AV11ConveAdicod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01XC2_A3CliCod[0] ;
         A1564CliPaiConve = P01XC2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01XC2_A1565CliConvenio[0] ;
         A996ConveAdicod = P01XC2_A996ConveAdicod[0] ;
         A999ConveAdiVig = P01XC2_A999ConveAdiVig[0] ;
         AV12ConveAdiVig = A999ConveAdiVig ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getultiadiimportevig.this.AV12ConveAdiVig;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12ConveAdiVig = GXutil.nullDate() ;
      scmdbuf = "" ;
      P01XC2_A3CliCod = new int[1] ;
      P01XC2_A1564CliPaiConve = new short[1] ;
      P01XC2_A1565CliConvenio = new String[] {""} ;
      P01XC2_A996ConveAdicod = new String[] {""} ;
      P01XC2_A999ConveAdiVig = new java.util.Date[] {GXutil.nullDate()} ;
      A1565CliConvenio = "" ;
      A996ConveAdicod = "" ;
      A999ConveAdiVig = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getultiadiimportevig__default(),
         new Object[] {
             new Object[] {
            P01XC2_A3CliCod, P01XC2_A1564CliPaiConve, P01XC2_A1565CliConvenio, P01XC2_A996ConveAdicod, P01XC2_A999ConveAdiVig
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9clipaiconve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV8clicod ;
   private int A3CliCod ;
   private String AV10cliconvenio ;
   private String AV11ConveAdicod ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A996ConveAdicod ;
   private java.util.Date AV12ConveAdiVig ;
   private java.util.Date A999ConveAdiVig ;
   private java.util.Date[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P01XC2_A3CliCod ;
   private short[] P01XC2_A1564CliPaiConve ;
   private String[] P01XC2_A1565CliConvenio ;
   private String[] P01XC2_A996ConveAdicod ;
   private java.util.Date[] P01XC2_A999ConveAdiVig ;
}

final  class getultiadiimportevig__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01XC2", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiVig FROM convenio_adicionalimportes WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveAdicod = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiVig DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
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
               stmt.setString(4, (String)parms[3], 20);
               return;
      }
   }

}

