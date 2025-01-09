package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newarea extends GXProcedure
{
   public newarea( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newarea.class ), "" );
   }

   public newarea( int remoteHandle ,
                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        boolean aP3 ,
                        boolean aP4 ,
                        int aP5 ,
                        int aP6 ,
                        String aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             boolean aP3 ,
                             boolean aP4 ,
                             int aP5 ,
                             int aP6 ,
                             String aP7 )
   {
      newarea.this.AV15CliCod = aP0;
      newarea.this.AV16SecCodigo = aP1;
      newarea.this.AV8SecDescrip = aP2;
      newarea.this.AV14SecApoOpc = aP3;
      newarea.this.AV9SecHabilitada = aP4;
      newarea.this.AV10SecRelSec = aP5;
      newarea.this.AV11SecRelSecCli = aP6;
      newarea.this.AV12SecPadre = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE Seccion

      */
      A3CliCod = AV15CliCod ;
      A13SecCodigo = AV16SecCodigo ;
      A329SecDescrip = AV8SecDescrip ;
      A2308SecApoOpc = AV14SecApoOpc ;
      A330SecHabilitada = AV9SecHabilitada ;
      GXt_char1 = A675SecDescripSinAc ;
      GXv_char2[0] = GXt_char1 ;
      new web.sacaracentos2(remoteHandle, context).execute( A329SecDescrip, GXv_char2) ;
      newarea.this.GXt_char1 = GXv_char2[0] ;
      A675SecDescripSinAc = GXt_char1 ;
      A1984SecRelSec = AV10SecRelSec ;
      A1985SecRelSecCli = AV11SecRelSecCli ;
      A1986SecPadre = AV12SecPadre ;
      AV13area_old.setgxTv_Sdtarea_old_Secdescrip( GXutil.trim( AV8SecDescrip) );
      AV13area_old.setgxTv_Sdtarea_old_Sechabilitada( AV9SecHabilitada );
      AV13area_old.setgxTv_Sdtarea_old_Secapoopc( AV14SecApoOpc );
      A2033SecOld = AV13area_old.toJSonString(false, true) ;
      /* Using cursor P02BM2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A329SecDescrip, Boolean.valueOf(A330SecHabilitada), A675SecDescripSinAc, Integer.valueOf(A1984SecRelSec), Integer.valueOf(A1985SecRelSecCli), A1986SecPadre, A2033SecOld, Boolean.valueOf(A2308SecApoOpc)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Seccion");
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
      Application.commitDataStores(context, remoteHandle, pr_default, "newarea");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A13SecCodigo = "" ;
      A329SecDescrip = "" ;
      A675SecDescripSinAc = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      A1986SecPadre = "" ;
      AV13area_old = new web.Sdtarea_old(remoteHandle, context);
      A2033SecOld = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newarea__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV15CliCod ;
   private int AV10SecRelSec ;
   private int AV11SecRelSecCli ;
   private int GX_INS43 ;
   private int A3CliCod ;
   private int A1984SecRelSec ;
   private int A1985SecRelSecCli ;
   private String AV16SecCodigo ;
   private String AV12SecPadre ;
   private String A13SecCodigo ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String A1986SecPadre ;
   private String Gx_emsg ;
   private boolean AV14SecApoOpc ;
   private boolean AV9SecHabilitada ;
   private boolean A2308SecApoOpc ;
   private boolean A330SecHabilitada ;
   private String A2033SecOld ;
   private String AV8SecDescrip ;
   private String A329SecDescrip ;
   private String A675SecDescripSinAc ;
   private web.Sdtarea_old AV13area_old ;
   private IDataStoreProvider pr_default ;
}

final  class newarea__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P02BM2", "SAVEPOINT gxupdate;INSERT INTO Seccion(CliCod, SecCodigo, SecDescrip, SecHabilitada, SecDescripSinAc, SecRelSec, SecRelSecCli, SecPadre, SecOld, SecApoOpc, SecRelRef) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setString(8, (String)parms[7], 20);
               stmt.setNLongVarchar(9, (String)parms[8], false);
               stmt.setBoolean(10, ((Boolean) parms[9]).booleanValue());
               return;
      }
   }

}

