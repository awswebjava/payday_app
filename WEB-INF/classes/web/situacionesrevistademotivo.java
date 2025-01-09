package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class situacionesrevistademotivo extends GXProcedure
{
   public situacionesrevistademotivo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( situacionesrevistademotivo.class ), "" );
   }

   public situacionesrevistademotivo( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem> executeUdp( int aP0 ,
                                                                                                         String aP1 )
   {
      situacionesrevistademotivo.this.aP2 = new GXBaseCollection[] {new GXBaseCollection<web.Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem>()};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        GXBaseCollection<web.Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem>[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             GXBaseCollection<web.Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem>[] aP2 )
   {
      situacionesrevistademotivo.this.AV11CliCod = aP0;
      situacionesrevistademotivo.this.AV10LegMegCodigo = aP1;
      situacionesrevistademotivo.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV11CliCod, 6, 0))+httpContext.getMessage( " &LegMegCodigo ", "")+GXutil.trim( AV10LegMegCodigo)) ;
      /* Using cursor P01G92 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), AV10LegMegCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A11MegCodigo = P01G92_A11MegCodigo[0] ;
         A3CliCod = P01G92_A3CliCod[0] ;
         A1601MegSitRevista = P01G92_A1601MegSitRevista[0] ;
         A1604MegSitRevDescrip = P01G92_A1604MegSitRevDescrip[0] ;
         A1606MegSitRevDef = P01G92_A1606MegSitRevDef[0] ;
         A1604MegSitRevDescrip = P01G92_A1604MegSitRevDescrip[0] ;
         AV9item = (web.Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem)new web.Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem(remoteHandle, context);
         AV9item.setgxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevcodigo( A1601MegSitRevista );
         AV9item.setgxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevdescrip( A1604MegSitRevDescrip );
         AV9item.setgxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Megsitrevdef( A1606MegSitRevDef );
         AV8sdt_situacion_revista_afip.add(AV9item, 0);
         new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "agrega ", "")+GXutil.trim( GXutil.str( A1601MegSitRevista, 3, 0))+httpContext.getMessage( " MegSitRevDescrip ", "")+GXutil.trim( A1604MegSitRevDescrip)) ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = situacionesrevistademotivo.this.AV8sdt_situacion_revista_afip;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8sdt_situacion_revista_afip = new GXBaseCollection<web.Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem>(web.Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem.class, "sdt_situacion_revista_afipItem", "PayDay", remoteHandle);
      AV14Pgmname = "" ;
      scmdbuf = "" ;
      P01G92_A11MegCodigo = new String[] {""} ;
      P01G92_A3CliCod = new int[1] ;
      P01G92_A1601MegSitRevista = new short[1] ;
      P01G92_A1604MegSitRevDescrip = new String[] {""} ;
      P01G92_A1606MegSitRevDef = new boolean[] {false} ;
      A11MegCodigo = "" ;
      A1604MegSitRevDescrip = "" ;
      AV9item = new web.Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.situacionesrevistademotivo__default(),
         new Object[] {
             new Object[] {
            P01G92_A11MegCodigo, P01G92_A3CliCod, P01G92_A1601MegSitRevista, P01G92_A1604MegSitRevDescrip, P01G92_A1606MegSitRevDef
            }
         }
      );
      AV14Pgmname = "situacionesRevistaDeMotivo" ;
      /* GeneXus formulas. */
      AV14Pgmname = "situacionesRevistaDeMotivo" ;
      Gx_err = (short)(0) ;
   }

   private short A1601MegSitRevista ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private String AV10LegMegCodigo ;
   private String AV14Pgmname ;
   private String scmdbuf ;
   private String A11MegCodigo ;
   private boolean A1606MegSitRevDef ;
   private String A1604MegSitRevDescrip ;
   private GXBaseCollection<web.Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem>[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01G92_A11MegCodigo ;
   private int[] P01G92_A3CliCod ;
   private short[] P01G92_A1601MegSitRevista ;
   private String[] P01G92_A1604MegSitRevDescrip ;
   private boolean[] P01G92_A1606MegSitRevDef ;
   private GXBaseCollection<web.Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem> AV8sdt_situacion_revista_afip ;
   private web.Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem AV9item ;
}

final  class situacionesrevistademotivo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01G92", "SELECT T1.MegCodigo, T1.CliCod, T1.MegSitRevista AS MegSitRevista, T2.SitRevDescrip AS MegSitRevDescrip, T1.MegSitRevDef FROM (MotivoEgresoRevistaAfip T1 INNER JOIN SituacionRevistaAFIP T2 ON T2.SitRevCodigo = T1.MegSitRevista) WHERE T1.CliCod = ? and T1.MegCodigo = ( ?) ORDER BY T1.CliCod, T1.MegCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
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
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

