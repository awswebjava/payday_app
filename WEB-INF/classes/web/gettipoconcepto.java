package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gettipoconcepto extends GXProcedure
{
   public gettipoconcepto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gettipoconcepto.class ), "" );
   }

   public gettipoconcepto( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 ,
                             String aP1 )
   {
      gettipoconcepto.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      gettipoconcepto.this.AV8TipoConPai = aP0;
      gettipoconcepto.this.AV9TipoConTipo = aP1;
      gettipoconcepto.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02262 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8TipoConPai), AV9TipoConTipo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2157TipoConTipo = P02262_A2157TipoConTipo[0] ;
         A2120TipoConPai = P02262_A2120TipoConPai[0] ;
         A37TipoConCod = P02262_A37TipoConCod[0] ;
         AV10TipoConCod = A37TipoConCod ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = gettipoconcepto.this.AV10TipoConCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10TipoConCod = "" ;
      scmdbuf = "" ;
      P02262_A2157TipoConTipo = new String[] {""} ;
      P02262_A2120TipoConPai = new short[1] ;
      P02262_A37TipoConCod = new String[] {""} ;
      A2157TipoConTipo = "" ;
      A37TipoConCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.gettipoconcepto__default(),
         new Object[] {
             new Object[] {
            P02262_A2157TipoConTipo, P02262_A2120TipoConPai, P02262_A37TipoConCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8TipoConPai ;
   private short A2120TipoConPai ;
   private short Gx_err ;
   private String AV9TipoConTipo ;
   private String AV10TipoConCod ;
   private String scmdbuf ;
   private String A2157TipoConTipo ;
   private String A37TipoConCod ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P02262_A2157TipoConTipo ;
   private short[] P02262_A2120TipoConPai ;
   private String[] P02262_A37TipoConCod ;
}

final  class gettipoconcepto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02262", "SELECT TipoConTipo, TipoConPai, TipoConCod FROM TipoDeConcepto WHERE (TipoConPai = ?) AND (TipoConTipo = ( ?)) ORDER BY TipoConPai ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

