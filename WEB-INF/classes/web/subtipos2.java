package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class subtipos2 extends GXProcedure
{
   public subtipos2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( subtipos2.class ), "" );
   }

   public subtipos2( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.Sdtsdt_subtipos_sdt_subtiposItem> executeUdp( String aP0 ,
                                                                             String aP1 )
   {
      subtipos2.this.aP2 = new GXBaseCollection[] {new GXBaseCollection<web.Sdtsdt_subtipos_sdt_subtiposItem>()};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        GXBaseCollection<web.Sdtsdt_subtipos_sdt_subtiposItem>[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             GXBaseCollection<web.Sdtsdt_subtipos_sdt_subtiposItem>[] aP2 )
   {
      subtipos2.this.AV10TipoConCod = aP0;
      subtipos2.this.AV11SubTipoConCod1 = aP1;
      subtipos2.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P011G2 */
      pr_default.execute(0, new Object[] {AV10TipoConCod, AV11SubTipoConCod1});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A38SubTipoConCod1 = P011G2_A38SubTipoConCod1[0] ;
         A37TipoConCod = P011G2_A37TipoConCod[0] ;
         A39SubTipoConCod2 = P011G2_A39SubTipoConCod2[0] ;
         A372SubTipoConDes2 = P011G2_A372SubTipoConDes2[0] ;
         AV9item = (web.Sdtsdt_subtipos_sdt_subtiposItem)new web.Sdtsdt_subtipos_sdt_subtiposItem(remoteHandle, context);
         AV9item.setgxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipoconcod1( A39SubTipoConCod2 );
         AV9item.setgxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipocondes1( A372SubTipoConDes2 );
         AV8sdt_subtipos.add(AV9item, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = subtipos2.this.AV8sdt_subtipos;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8sdt_subtipos = new GXBaseCollection<web.Sdtsdt_subtipos_sdt_subtiposItem>(web.Sdtsdt_subtipos_sdt_subtiposItem.class, "sdt_subtiposItem", "PayDay", remoteHandle);
      scmdbuf = "" ;
      P011G2_A38SubTipoConCod1 = new String[] {""} ;
      P011G2_A37TipoConCod = new String[] {""} ;
      P011G2_A39SubTipoConCod2 = new String[] {""} ;
      P011G2_A372SubTipoConDes2 = new String[] {""} ;
      A38SubTipoConCod1 = "" ;
      A37TipoConCod = "" ;
      A39SubTipoConCod2 = "" ;
      A372SubTipoConDes2 = "" ;
      AV9item = new web.Sdtsdt_subtipos_sdt_subtiposItem(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.subtipos2__default(),
         new Object[] {
             new Object[] {
            P011G2_A38SubTipoConCod1, P011G2_A37TipoConCod, P011G2_A39SubTipoConCod2, P011G2_A372SubTipoConDes2
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV10TipoConCod ;
   private String AV11SubTipoConCod1 ;
   private String scmdbuf ;
   private String A38SubTipoConCod1 ;
   private String A37TipoConCod ;
   private String A39SubTipoConCod2 ;
   private String A372SubTipoConDes2 ;
   private GXBaseCollection<web.Sdtsdt_subtipos_sdt_subtiposItem>[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P011G2_A38SubTipoConCod1 ;
   private String[] P011G2_A37TipoConCod ;
   private String[] P011G2_A39SubTipoConCod2 ;
   private String[] P011G2_A372SubTipoConDes2 ;
   private GXBaseCollection<web.Sdtsdt_subtipos_sdt_subtiposItem> AV8sdt_subtipos ;
   private web.Sdtsdt_subtipos_sdt_subtiposItem AV9item ;
}

final  class subtipos2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P011G2", "SELECT SubTipoConCod1, TipoConCod, SubTipoConCod2, SubTipoConDes2 FROM tipo_concepto_subtipo2 WHERE TipoConCod = ( ?) and SubTipoConCod1 = ( ?) ORDER BY TipoConCod, SubTipoConCod1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

