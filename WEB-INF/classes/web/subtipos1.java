package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class subtipos1 extends GXProcedure
{
   public subtipos1( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( subtipos1.class ), "" );
   }

   public subtipos1( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.Sdtsdt_subtipos_sdt_subtiposItem> executeUdp( String aP0 )
   {
      subtipos1.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<web.Sdtsdt_subtipos_sdt_subtiposItem>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        GXBaseCollection<web.Sdtsdt_subtipos_sdt_subtiposItem>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             GXBaseCollection<web.Sdtsdt_subtipos_sdt_subtiposItem>[] aP1 )
   {
      subtipos1.this.AV10TipoConCod = aP0;
      subtipos1.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P011F2 */
      pr_default.execute(0, new Object[] {AV10TipoConCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A37TipoConCod = P011F2_A37TipoConCod[0] ;
         A38SubTipoConCod1 = P011F2_A38SubTipoConCod1[0] ;
         A371SubTipoConDes1 = P011F2_A371SubTipoConDes1[0] ;
         AV9item = (web.Sdtsdt_subtipos_sdt_subtiposItem)new web.Sdtsdt_subtipos_sdt_subtiposItem(remoteHandle, context);
         AV9item.setgxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipoconcod1( A38SubTipoConCod1 );
         AV9item.setgxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipocondes1( A371SubTipoConDes1 );
         AV8sdt_subtipos.add(AV9item, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = subtipos1.this.AV8sdt_subtipos;
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
      P011F2_A37TipoConCod = new String[] {""} ;
      P011F2_A38SubTipoConCod1 = new String[] {""} ;
      P011F2_A371SubTipoConDes1 = new String[] {""} ;
      A37TipoConCod = "" ;
      A38SubTipoConCod1 = "" ;
      A371SubTipoConDes1 = "" ;
      AV9item = new web.Sdtsdt_subtipos_sdt_subtiposItem(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.subtipos1__default(),
         new Object[] {
             new Object[] {
            P011F2_A37TipoConCod, P011F2_A38SubTipoConCod1, P011F2_A371SubTipoConDes1
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV10TipoConCod ;
   private String scmdbuf ;
   private String A37TipoConCod ;
   private String A38SubTipoConCod1 ;
   private String A371SubTipoConDes1 ;
   private GXBaseCollection<web.Sdtsdt_subtipos_sdt_subtiposItem>[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P011F2_A37TipoConCod ;
   private String[] P011F2_A38SubTipoConCod1 ;
   private String[] P011F2_A371SubTipoConDes1 ;
   private GXBaseCollection<web.Sdtsdt_subtipos_sdt_subtiposItem> AV8sdt_subtipos ;
   private web.Sdtsdt_subtipos_sdt_subtiposItem AV9item ;
}

final  class subtipos1__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P011F2", "SELECT TipoConCod, SubTipoConCod1, SubTipoConDes1 FROM TipoDeConceptoSubtipo1 WHERE TipoConCod = ( ?) ORDER BY TipoConCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
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
               return;
      }
   }

}

