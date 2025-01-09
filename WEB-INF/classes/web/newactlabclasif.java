package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newactlabclasif extends GXProcedure
{
   public newactlabclasif( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newactlabclasif.class ), "" );
   }

   public newactlabclasif( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 ,
                        int aP1 ,
                        String aP2 ,
                        String aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( short aP0 ,
                             int aP1 ,
                             String aP2 ,
                             String aP3 )
   {
      newactlabclasif.this.AV10PaiCod = aP0;
      newactlabclasif.this.AV9ActLabNro = aP1;
      newactlabclasif.this.AV8ActLabDescrip = aP2;
      newactlabclasif.this.AV11ActLabAreaGen = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "paicod ", "")+GXutil.trim( GXutil.str( AV10PaiCod, 4, 0))) ;
      /*
         INSERT RECORD ON TABLE ActividadLaboralClasificada

      */
      A46PaiCod = AV10PaiCod ;
      A2217ActLabNro = AV9ActLabNro ;
      GXv_char1[0] = AV13AUXActLabDescrip ;
      new web.capitalizartexto(remoteHandle, context).execute( AV8ActLabDescrip, GXv_char1) ;
      newactlabclasif.this.AV13AUXActLabDescrip = GXv_char1[0] ;
      A2218ActLabDescrip = GXutil.trim( AV13AUXActLabDescrip) ;
      GXv_char1[0] = AV12ActLabDesSinAc ;
      new web.sacaracentos2(remoteHandle, context).execute( AV8ActLabDescrip, GXv_char1) ;
      newactlabclasif.this.AV12ActLabDesSinAc = GXv_char1[0] ;
      A2220ActLabDesSinAc = GXutil.trim( GXutil.upper( AV12ActLabDesSinAc)) ;
      A2219ActLabAreaGen = AV11ActLabAreaGen ;
      /* Using cursor P028D2 */
      pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod), Integer.valueOf(A2217ActLabNro), A2218ActLabDescrip, A2220ActLabDesSinAc, A2219ActLabAreaGen});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("ActividadLaboralClasificada");
      if ( (pr_default.getStatus(0) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "newactlabclasif");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16Pgmname = "" ;
      AV13AUXActLabDescrip = "" ;
      A2218ActLabDescrip = "" ;
      AV12ActLabDesSinAc = "" ;
      GXv_char1 = new String[1] ;
      A2220ActLabDesSinAc = "" ;
      A2219ActLabAreaGen = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newactlabclasif__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      AV16Pgmname = "newActLabClasif" ;
      /* GeneXus formulas. */
      AV16Pgmname = "newActLabClasif" ;
      Gx_err = (short)(0) ;
   }

   private short AV10PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV9ActLabNro ;
   private int GX_INS280 ;
   private int A2217ActLabNro ;
   private String AV16Pgmname ;
   private String GXv_char1[] ;
   private String Gx_emsg ;
   private String AV8ActLabDescrip ;
   private String AV11ActLabAreaGen ;
   private String AV13AUXActLabDescrip ;
   private String A2218ActLabDescrip ;
   private String AV12ActLabDesSinAc ;
   private String A2220ActLabDesSinAc ;
   private String A2219ActLabAreaGen ;
   private IDataStoreProvider pr_default ;
}

final  class newactlabclasif__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P028D2", "SAVEPOINT gxupdate;INSERT INTO ActividadLaboralClasificada(PaiCod, ActLabNro, ActLabDescrip, ActLabDesSinAc, ActLabAreaGen) VALUES(?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               return;
      }
   }

}

