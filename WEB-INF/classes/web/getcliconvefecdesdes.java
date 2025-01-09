package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getcliconvefecdesdes extends GXProcedure
{
   public getcliconvefecdesdes( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getcliconvefecdesdes.class ), "" );
   }

   public getcliconvefecdesdes( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     short aP1 ,
                                     String aP2 ,
                                     java.util.Date[] aP3 ,
                                     java.util.Date[] aP4 ,
                                     java.util.Date[] aP5 )
   {
      getcliconvefecdesdes.this.aP6 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        java.util.Date[] aP3 ,
                        java.util.Date[] aP4 ,
                        java.util.Date[] aP5 ,
                        java.util.Date[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             java.util.Date[] aP3 ,
                             java.util.Date[] aP4 ,
                             java.util.Date[] aP5 ,
                             java.util.Date[] aP6 )
   {
      getcliconvefecdesdes.this.AV12CliCod = aP0;
      getcliconvefecdesdes.this.AV9CliPaiConve = aP1;
      getcliconvefecdesdes.this.AV10CliConvenio = aP2;
      getcliconvefecdesdes.this.aP3 = aP3;
      getcliconvefecdesdes.this.aP4 = aP4;
      getcliconvefecdesdes.this.aP5 = aP5;
      getcliconvefecdesdes.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01XE2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV9CliPaiConve), AV10CliConvenio});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01XE2_A3CliCod[0] ;
         A1564CliPaiConve = P01XE2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01XE2_A1565CliConvenio[0] ;
         /* Using cursor P01XE3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A996ConveAdicod = P01XE3_A996ConveAdicod[0] ;
            GXv_date1[0] = AV8ConveAdiVig ;
            new web.getultiadiimportevig(remoteHandle, context).execute( A3CliCod, A1564CliPaiConve, A1565CliConvenio, A996ConveAdicod, GXv_date1) ;
            getcliconvefecdesdes.this.AV8ConveAdiVig = GXv_date1[0] ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(1);
         }
         pr_default.close(1);
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      GXv_date1[0] = AV15CliConveVig ;
      new web.getulticonvevig(remoteHandle, context).execute( AV12CliCod, AV9CliPaiConve, AV10CliConvenio, AV19fecha, GXv_date1) ;
      getcliconvefecdesdes.this.AV15CliConveVig = GXv_date1[0] ;
      GXv_date1[0] = AV13CatVigencia ;
      GXv_int2[0] = AV14CatFrecAct ;
      new web.getconveultivig(remoteHandle, context).execute( AV12CliCod, AV9CliPaiConve, AV10CliConvenio, AV18date, GXv_date1, GXv_int2) ;
      getcliconvefecdesdes.this.AV13CatVigencia = GXv_date1[0] ;
      getcliconvefecdesdes.this.AV14CatFrecAct = GXv_int2[0] ;
      GXv_date1[0] = AV11CliConveImpVig ;
      new web.getulticonveimpvig(remoteHandle, context).execute( A3CliCod, A1564CliPaiConve, A1565CliConvenio, GXv_date1) ;
      getcliconvefecdesdes.this.AV11CliConveImpVig = GXv_date1[0] ;
      AV16cant = (short)(-2) ;
      GXt_date3 = AV17defaultCliConveVig ;
      GXv_date1[0] = GXt_date3 ;
      new web.fechadefaultvig(remoteHandle, context).execute( GXv_date1) ;
      getcliconvefecdesdes.this.GXt_date3 = GXv_date1[0] ;
      AV17defaultCliConveVig = GXt_date3 ;
      if ( !( GXutil.dateCompare(GXutil.resetTime(AV15CliConveVig), GXutil.resetTime(AV17defaultCliConveVig)) ) )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, httpContext.getMessage( "&CliConveVig ", "")+GXutil.trim( localUtil.dtoc( AV15CliConveVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &cant ", "")+GXutil.trim( GXutil.str( AV16cant, 4, 0))) ;
         AV15CliConveVig = GXutil.addmth( AV15CliConveVig, AV16cant) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, httpContext.getMessage( "&CliConveVig ", "")+GXutil.trim( localUtil.dtoc( AV15CliConveVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      AV11CliConveImpVig = GXutil.addmth( AV11CliConveImpVig, AV16cant) ;
      AV8ConveAdiVig = GXutil.addmth( AV8ConveAdiVig, AV16cant) ;
      AV13CatVigencia = GXutil.addmth( AV13CatVigencia, AV16cant) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getcliconvefecdesdes.this.AV15CliConveVig;
      this.aP4[0] = getcliconvefecdesdes.this.AV11CliConveImpVig;
      this.aP5[0] = getcliconvefecdesdes.this.AV8ConveAdiVig;
      this.aP6[0] = getcliconvefecdesdes.this.AV13CatVigencia;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15CliConveVig = GXutil.nullDate() ;
      AV11CliConveImpVig = GXutil.nullDate() ;
      AV8ConveAdiVig = GXutil.nullDate() ;
      AV13CatVigencia = GXutil.nullDate() ;
      scmdbuf = "" ;
      P01XE2_A3CliCod = new int[1] ;
      P01XE2_A1564CliPaiConve = new short[1] ;
      P01XE2_A1565CliConvenio = new String[] {""} ;
      A1565CliConvenio = "" ;
      P01XE3_A3CliCod = new int[1] ;
      P01XE3_A1564CliPaiConve = new short[1] ;
      P01XE3_A1565CliConvenio = new String[] {""} ;
      P01XE3_A996ConveAdicod = new String[] {""} ;
      A996ConveAdicod = "" ;
      AV19fecha = GXutil.nullDate() ;
      AV18date = GXutil.nullDate() ;
      GXv_int2 = new byte[1] ;
      AV17defaultCliConveVig = GXutil.nullDate() ;
      GXt_date3 = GXutil.nullDate() ;
      GXv_date1 = new java.util.Date[1] ;
      AV24Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getcliconvefecdesdes__default(),
         new Object[] {
             new Object[] {
            P01XE2_A3CliCod, P01XE2_A1564CliPaiConve, P01XE2_A1565CliConvenio
            }
            , new Object[] {
            P01XE3_A3CliCod, P01XE3_A1564CliPaiConve, P01XE3_A1565CliConvenio, P01XE3_A996ConveAdicod
            }
         }
      );
      AV24Pgmname = "getCliConveFecDesdes" ;
      /* GeneXus formulas. */
      AV24Pgmname = "getCliConveFecDesdes" ;
      Gx_err = (short)(0) ;
   }

   private byte AV14CatFrecAct ;
   private byte GXv_int2[] ;
   private short AV9CliPaiConve ;
   private short A1564CliPaiConve ;
   private short AV16cant ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int A3CliCod ;
   private String AV10CliConvenio ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A996ConveAdicod ;
   private String AV24Pgmname ;
   private java.util.Date AV15CliConveVig ;
   private java.util.Date AV11CliConveImpVig ;
   private java.util.Date AV8ConveAdiVig ;
   private java.util.Date AV13CatVigencia ;
   private java.util.Date AV19fecha ;
   private java.util.Date AV18date ;
   private java.util.Date AV17defaultCliConveVig ;
   private java.util.Date GXt_date3 ;
   private java.util.Date GXv_date1[] ;
   private java.util.Date[] aP6 ;
   private java.util.Date[] aP3 ;
   private java.util.Date[] aP4 ;
   private java.util.Date[] aP5 ;
   private IDataStoreProvider pr_default ;
   private int[] P01XE2_A3CliCod ;
   private short[] P01XE2_A1564CliPaiConve ;
   private String[] P01XE2_A1565CliConvenio ;
   private int[] P01XE3_A3CliCod ;
   private short[] P01XE3_A1564CliPaiConve ;
   private String[] P01XE3_A1565CliConvenio ;
   private String[] P01XE3_A996ConveAdicod ;
}

final  class getcliconvefecdesdes__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01XE2", "SELECT CliCod, CliPaiConve, CliConvenio FROM ClienteConvenios WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01XE3", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod FROM convenio_adicional WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
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
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

