package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newpuesto extends GXProcedure
{
   public newpuesto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newpuesto.class ), "" );
   }

   public newpuesto( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String aP4 ,
                        boolean aP5 ,
                        int aP6 ,
                        int aP7 ,
                        String aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             boolean aP5 ,
                             int aP6 ,
                             int aP7 ,
                             String aP8 )
   {
      newpuesto.this.AV8CliCod = aP0;
      newpuesto.this.AV18SecCodigo = aP1;
      newpuesto.this.AV13PuestoCodigo = aP2;
      newpuesto.this.AV12PuestoDescrip = aP3;
      newpuesto.this.AV19parmPuestoDescripSinAc = aP4;
      newpuesto.this.AV11PuestoHorasExt = aP5;
      newpuesto.this.AV10PuestoRelSec = aP6;
      newpuesto.this.AV9PuestoRelSecCli = aP7;
      newpuesto.this.AV16PuestoPadre = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE Puesto

      */
      A3CliCod = AV8CliCod ;
      A13SecCodigo = AV18SecCodigo ;
      A1240PuestoCodigo = AV13PuestoCodigo ;
      A1241PuestoDescrip = AV12PuestoDescrip ;
      if ( ! (GXutil.strcmp("", AV19parmPuestoDescripSinAc)==0) )
      {
         A1242PuestoDescripSinAc = AV19parmPuestoDescripSinAc ;
      }
      else
      {
         GXv_char1[0] = AV17PuestoDescripSinAc ;
         new web.sacaracentos2(remoteHandle, context).execute( AV12PuestoDescrip, GXv_char1) ;
         newpuesto.this.AV17PuestoDescripSinAc = GXv_char1[0] ;
         A1242PuestoDescripSinAc = AV17PuestoDescripSinAc ;
      }
      A1255PuestoHorasExt = AV11PuestoHorasExt ;
      A1987PuestoRelSec = AV10PuestoRelSec ;
      A1988PuestoRelSecCli = AV9PuestoRelSecCli ;
      A1989PuestoPadre = AV16PuestoPadre ;
      AV20puesto_old.setgxTv_Sdtpuesto_old_Puestodescrip( GXutil.trim( AV12PuestoDescrip) );
      AV20puesto_old.setgxTv_Sdtpuesto_old_Puestohorasext( AV11PuestoHorasExt );
      A2034PuestoOld = AV20puesto_old.toJSonString(false, true) ;
      /* Using cursor P02552 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo, A1241PuestoDescrip, A1242PuestoDescripSinAc, Boolean.valueOf(A1255PuestoHorasExt), Integer.valueOf(A1987PuestoRelSec), Integer.valueOf(A1988PuestoRelSecCli), A1989PuestoPadre, A2034PuestoOld});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Puesto");
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
      A1240PuestoCodigo = "" ;
      A1241PuestoDescrip = "" ;
      A1242PuestoDescripSinAc = "" ;
      AV17PuestoDescripSinAc = "" ;
      GXv_char1 = new String[1] ;
      A1989PuestoPadre = "" ;
      AV20puesto_old = new web.Sdtpuesto_old(remoteHandle, context);
      A2034PuestoOld = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newpuesto__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10PuestoRelSec ;
   private int AV9PuestoRelSecCli ;
   private int GX_INS153 ;
   private int A3CliCod ;
   private int A1987PuestoRelSec ;
   private int A1988PuestoRelSecCli ;
   private String AV18SecCodigo ;
   private String AV13PuestoCodigo ;
   private String AV16PuestoPadre ;
   private String A13SecCodigo ;
   private String A1240PuestoCodigo ;
   private String GXv_char1[] ;
   private String A1989PuestoPadre ;
   private String Gx_emsg ;
   private boolean AV11PuestoHorasExt ;
   private boolean A1255PuestoHorasExt ;
   private String A2034PuestoOld ;
   private String AV12PuestoDescrip ;
   private String AV19parmPuestoDescripSinAc ;
   private String A1241PuestoDescrip ;
   private String A1242PuestoDescripSinAc ;
   private String AV17PuestoDescripSinAc ;
   private web.Sdtpuesto_old AV20puesto_old ;
   private IDataStoreProvider pr_default ;
}

final  class newpuesto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P02552", "SAVEPOINT gxupdate;INSERT INTO Puesto(CliCod, SecCodigo, PuestoCodigo, PuestoDescrip, PuestoDescripSinAc, PuestoHorasExt, PuestoRelSec, PuestoRelSecCli, PuestoPadre, PuestoOld, PuestoRelRef) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setString(9, (String)parms[8], 20);
               stmt.setNLongVarchar(10, (String)parms[9], false);
               return;
      }
   }

}

