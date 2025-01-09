package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newbanco extends GXProcedure
{
   public newbanco( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newbanco.class ), "" );
   }

   public newbanco( int remoteHandle ,
                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        boolean aP4 ,
                        int aP5 ,
                        String aP6 ,
                        int aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             boolean aP4 ,
                             int aP5 ,
                             String aP6 ,
                             int aP7 )
   {
      newbanco.this.AV8CliCod = aP0;
      newbanco.this.AV12BanCod = aP1;
      newbanco.this.AV9BanDescrip = aP2;
      newbanco.this.AV11BanCUIT = aP3;
      newbanco.this.AV10BanHabilitado = aP4;
      newbanco.this.AV14BanRelSecCli = aP5;
      newbanco.this.AV15BancodPadre = aP6;
      newbanco.this.AV16BanRelSec = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE Banco

      */
      A3CliCod = AV8CliCod ;
      A7BanCod = AV12BanCod ;
      A117BanDescrip = AV9BanDescrip ;
      A118BanHabilitado = AV10BanHabilitado ;
      A116BanCUIT = AV11BanCUIT ;
      n116BanCUIT = false ;
      GXt_char1 = A679BanDescripSinAc ;
      GXv_char2[0] = GXt_char1 ;
      new web.sacaracentos2(remoteHandle, context).execute( A117BanDescrip, GXv_char2) ;
      newbanco.this.GXt_char1 = GXv_char2[0] ;
      A679BanDescripSinAc = GXt_char1 ;
      AV13banco_old.setgxTv_Sdtbanco_old_Bancuit( GXutil.trim( AV11BanCUIT) );
      AV13banco_old.setgxTv_Sdtbanco_old_Bandescrip( GXutil.trim( AV9BanDescrip) );
      AV13banco_old.setgxTv_Sdtbanco_old_Banhabilitado( AV10BanHabilitado );
      A2024BancoOld = AV13banco_old.toJSonString(false, true) ;
      A1979BanRelSecCli = AV14BanRelSecCli ;
      A1980BancodPadre = AV15BancodPadre ;
      A1978BanRelSec = AV16BanRelSec ;
      /* Using cursor P01WW2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A7BanCod, A117BanDescrip, Boolean.valueOf(A118BanHabilitado), Boolean.valueOf(n116BanCUIT), A116BanCUIT, A679BanDescripSinAc, Integer.valueOf(A1978BanRelSec), Integer.valueOf(A1979BanRelSecCli), A1980BancodPadre, A2024BancoOld});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Banco");
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
      Application.commitDataStores(context, remoteHandle, pr_default, "newbanco");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A7BanCod = "" ;
      A117BanDescrip = "" ;
      A116BanCUIT = "" ;
      A679BanDescripSinAc = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      AV13banco_old = new web.Sdtbanco_old(remoteHandle, context);
      A2024BancoOld = "" ;
      A1980BancodPadre = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newbanco__default(),
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
   private int AV14BanRelSecCli ;
   private int AV16BanRelSec ;
   private int GX_INS4 ;
   private int A3CliCod ;
   private int A1979BanRelSecCli ;
   private int A1978BanRelSec ;
   private String AV12BanCod ;
   private String AV11BanCUIT ;
   private String AV15BancodPadre ;
   private String A7BanCod ;
   private String A116BanCUIT ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String A1980BancodPadre ;
   private String Gx_emsg ;
   private boolean AV10BanHabilitado ;
   private boolean A118BanHabilitado ;
   private boolean n116BanCUIT ;
   private String A2024BancoOld ;
   private String AV9BanDescrip ;
   private String A117BanDescrip ;
   private String A679BanDescripSinAc ;
   private web.Sdtbanco_old AV13banco_old ;
   private IDataStoreProvider pr_default ;
}

final  class newbanco__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01WW2", "SAVEPOINT gxupdate;INSERT INTO Banco(CliCod, BanCod, BanDescrip, BanHabilitado, BanCUIT, BanDescripSinAc, BanRelSec, BanRelSecCli, BancodPadre, BancoOld, BancoRelRef) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setString(2, (String)parms[1], 6);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(5, (String)parms[5], 13);
               }
               stmt.setVarchar(6, (String)parms[6], 400, false);
               stmt.setInt(7, ((Number) parms[7]).intValue());
               stmt.setInt(8, ((Number) parms[8]).intValue());
               stmt.setString(9, (String)parms[9], 6);
               stmt.setNLongVarchar(10, (String)parms[10], false);
               return;
      }
   }

}

