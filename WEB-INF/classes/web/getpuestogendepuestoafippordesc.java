package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpuestogendepuestoafippordesc extends GXProcedure
{
   public getpuestogendepuestoafippordesc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpuestogendepuestoafippordesc.class ), "" );
   }

   public getpuestogendepuestoafippordesc( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      getpuestogendepuestoafippordesc.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      getpuestogendepuestoafippordesc.this.AV10PueAfipDes = aP0;
      getpuestogendepuestoafippordesc.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P025D2 */
      pr_default.execute(0, new Object[] {AV10PueAfipDes});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2242PueAfipDesSinAc = P025D2_A2242PueAfipDesSinAc[0] ;
         A2241PueAfipGenDes = P025D2_A2241PueAfipGenDes[0] ;
         A2213PueAfipCod = P025D2_A2213PueAfipCod[0] ;
         AV8PueAfipGenDes = A2241PueAfipGenDes ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getpuestogendepuestoafippordesc.this.AV8PueAfipGenDes;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8PueAfipGenDes = "" ;
      scmdbuf = "" ;
      P025D2_A2242PueAfipDesSinAc = new String[] {""} ;
      P025D2_A2241PueAfipGenDes = new String[] {""} ;
      P025D2_A2213PueAfipCod = new String[] {""} ;
      A2242PueAfipDesSinAc = "" ;
      A2241PueAfipGenDes = "" ;
      A2213PueAfipCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getpuestogendepuestoafippordesc__default(),
         new Object[] {
             new Object[] {
            P025D2_A2242PueAfipDesSinAc, P025D2_A2241PueAfipGenDes, P025D2_A2213PueAfipCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String scmdbuf ;
   private String A2213PueAfipCod ;
   private String AV10PueAfipDes ;
   private String AV8PueAfipGenDes ;
   private String A2242PueAfipDesSinAc ;
   private String A2241PueAfipGenDes ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P025D2_A2242PueAfipDesSinAc ;
   private String[] P025D2_A2241PueAfipGenDes ;
   private String[] P025D2_A2213PueAfipCod ;
}

final  class getpuestogendepuestoafippordesc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P025D2", "SELECT PueAfipDesSinAc, PueAfipGenDes, PueAfipCod FROM PuestoAfip WHERE PueAfipDesSinAc = ( ?) ORDER BY PueAfipCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 4);
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
               stmt.setVarchar(1, (String)parms[0], 400);
               return;
      }
   }

}

