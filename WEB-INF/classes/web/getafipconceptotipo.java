package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getafipconceptotipo extends GXProcedure
{
   public getafipconceptotipo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getafipconceptotipo.class ), "" );
   }

   public getafipconceptotipo( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      getafipconceptotipo.this.aP1 = new String[] {""};
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
      getafipconceptotipo.this.AV9AFIPConCod = aP0;
      getafipconceptotipo.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV12GXLvl1 = (byte)(0) ;
      /* Using cursor P025W2 */
      pr_default.execute(0, new Object[] {AV9AFIPConCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A72AFIPConCod = P025W2_A72AFIPConCod[0] ;
         A387AfipConTipoConCod = P025W2_A387AfipConTipoConCod[0] ;
         AV12GXLvl1 = (byte)(1) ;
         AV8AfipConTipoConCod = A387AfipConTipoConCod ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV12GXLvl1 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV13Pgmname, httpContext.getMessage( "none \"", "")+GXutil.trim( AV9AFIPConCod)+"\"") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getafipconceptotipo.this.AV8AfipConTipoConCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8AfipConTipoConCod = "" ;
      scmdbuf = "" ;
      P025W2_A72AFIPConCod = new String[] {""} ;
      P025W2_A387AfipConTipoConCod = new String[] {""} ;
      A72AFIPConCod = "" ;
      A387AfipConTipoConCod = "" ;
      AV13Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getafipconceptotipo__default(),
         new Object[] {
             new Object[] {
            P025W2_A72AFIPConCod, P025W2_A387AfipConTipoConCod
            }
         }
      );
      AV13Pgmname = "getAfipConceptoTipo" ;
      /* GeneXus formulas. */
      AV13Pgmname = "getAfipConceptoTipo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV12GXLvl1 ;
   private short Gx_err ;
   private String AV9AFIPConCod ;
   private String AV8AfipConTipoConCod ;
   private String scmdbuf ;
   private String A72AFIPConCod ;
   private String A387AfipConTipoConCod ;
   private String AV13Pgmname ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P025W2_A72AFIPConCod ;
   private String[] P025W2_A387AfipConTipoConCod ;
}

final  class getafipconceptotipo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P025W2", "SELECT AFIPConCod, AfipConTipoConCod FROM AFIPConcepto WHERE RTRIM(LTRIM(AFIPConCod)) = ( RTRIM(LTRIM(?))) ORDER BY AFIPConCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 6);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
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
               stmt.setString(1, (String)parms[0], 6);
               return;
      }
   }

}

