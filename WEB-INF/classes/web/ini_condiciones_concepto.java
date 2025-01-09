package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ini_condiciones_concepto extends GXProcedure
{
   public ini_condiciones_concepto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ini_condiciones_concepto.class ), "" );
   }

   public ini_condiciones_concepto( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( short aP0 )
   {
      ini_condiciones_concepto.this.AV9PaiCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV12Pgmname, httpContext.getMessage( "paicod  ", "")+GXutil.trim( GXutil.str( AV9PaiCod, 4, 0))) ;
      AV14GXV2 = 1 ;
      AV13GXV1 = web.gxdomaincondicionliquidacion.getValues() ;
      while ( AV14GXV2 <= AV13GXV1.size() )
      {
         AV8item = (String)AV13GXV1.elementAt(-1+AV14GXV2) ;
         /*
            INSERT RECORD ON TABLE Condiciones_concepto

         */
         A953ConCondicion = AV8item ;
         A1757CondicionPais = AV9PaiCod ;
         A1758CondicionDescrip = httpContext.getMessage( web.gxdomaincondicionliquidacion.getDescription(httpContext,(String)AV8item), "") ;
         if ( ( GXutil.strcmp(AV8item, "A13") != 0 ) && ( GXutil.strcmp(AV8item, "A0") != 0 ) && ( GXutil.strcmp(AV8item, "A3") != 0 ) && ( GXutil.strcmp(AV8item, "A10") != 0 ) && ( GXutil.strcmp(AV8item, "B4") != 0 ) && ( GXutil.strcmp(AV8item, "B5") != 0 ) && ( GXutil.strcmp(AV8item, "B6") != 0 ) && ( GXutil.strcmp(AV8item, "B12") != 0 ) && ( GXutil.strcmp(AV8item, "B13") != 0 ) && ( GXutil.strcmp(AV8item, "B9") != 0 ) && ( GXutil.strcmp(AV8item, "B1") != 0 ) && ( GXutil.strcmp(AV8item, "A9") != 0 ) && ( GXutil.strcmp(AV8item, "B16") != 0 ) && ( GXutil.strcmp(AV8item, "A12") != 0 ) && ( GXutil.strcmp(AV8item, "B21") != 0 ) && ( GXutil.strcmp(AV8item, "B20") != 0 ) && ( GXutil.strcmp(AV8item, "B22") != 0 ) && ( GXutil.strcmp(AV8item, "B19") != 0 ) && ( GXutil.strcmp(AV8item, "B23") != 0 ) && ( GXutil.strcmp(AV8item, "B24") != 0 ) && ( GXutil.strcmp(AV8item, "R1") != 0 ) && ( GXutil.strcmp(AV8item, "MI") != 0 ) && ( GXutil.strcmp(AV8item, "AI") != 0 ) && ( GXutil.strcmp(AV8item, "B7") != 0 ) && ( GXutil.strcmp(AV8item, "H1") != 0 ) && ( GXutil.strcmp(AV8item, "LA") != 0 ) )
         {
            A1779CondLiqBasica = false ;
         }
         else
         {
            A1779CondLiqBasica = true ;
         }
         if ( ( GXutil.strcmp(AV8item, "A13") == 0 ) || ( GXutil.strcmp(AV8item, "A14") == 0 ) )
         {
            A1786CondSegPla = (byte)(2) ;
         }
         else
         {
            if ( ( GXutil.strcmp(AV8item, "B11") == 0 ) || ( GXutil.strcmp(AV8item, "N01") == 0 ) || ( GXutil.strcmp(AV8item, "A0") == 0 ) || ( GXutil.strcmp(AV8item, "H1") == 0 ) )
            {
               if ( GXutil.strcmp(AV8item, "B11") == 0 )
               {
                  A1786CondSegPla = (byte)(3) ;
               }
               else
               {
                  A1786CondSegPla = (byte)(1) ;
               }
            }
            else
            {
               A1786CondSegPla = (byte)(0) ;
            }
         }
         if ( ( GXutil.strcmp(AV8item, "B7") == 0 ) || ( GXutil.strcmp(AV8item, "A4") == 0 ) || ( GXutil.strcmp(AV8item, "MI") == 0 ) || ( GXutil.strcmp(AV8item, "AI") == 0 ) )
         {
            A2133CondRestaDias = true ;
         }
         else
         {
            A2133CondRestaDias = false ;
         }
         /* Using cursor P01KV2 */
         pr_default.execute(0, new Object[] {A953ConCondicion, Short.valueOf(A1757CondicionPais), A1758CondicionDescrip, Boolean.valueOf(A1779CondLiqBasica), Byte.valueOf(A1786CondSegPla), Boolean.valueOf(A2133CondRestaDias)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Condiciones_concepto");
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
         AV14GXV2 = (int)(AV14GXV2+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "ini_condiciones_concepto");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12Pgmname = "" ;
      AV13GXV1 = new GXSimpleCollection<String>(String.class, "internal", "");
      AV8item = "" ;
      A953ConCondicion = "" ;
      A1758CondicionDescrip = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.ini_condiciones_concepto__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      AV12Pgmname = "ini_condiciones_concepto" ;
      /* GeneXus formulas. */
      AV12Pgmname = "ini_condiciones_concepto" ;
      Gx_err = (short)(0) ;
   }

   private byte A1786CondSegPla ;
   private short AV9PaiCod ;
   private short A1757CondicionPais ;
   private short Gx_err ;
   private int AV14GXV2 ;
   private int GX_INS238 ;
   private String AV12Pgmname ;
   private String AV8item ;
   private String A953ConCondicion ;
   private String Gx_emsg ;
   private boolean A1779CondLiqBasica ;
   private boolean A2133CondRestaDias ;
   private String A1758CondicionDescrip ;
   private IDataStoreProvider pr_default ;
   private GXSimpleCollection<String> AV13GXV1 ;
}

final  class ini_condiciones_concepto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01KV2", "SAVEPOINT gxupdate;INSERT INTO Condiciones_concepto(ConCondicion, CondicionPais, CondicionDescrip, CondLiqBasica, CondSegPla, CondRestaDias) VALUES(?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setString(1, (String)parms[0], 20);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               return;
      }
   }

}

