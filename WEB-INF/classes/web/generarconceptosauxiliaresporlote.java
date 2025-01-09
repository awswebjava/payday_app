package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class generarconceptosauxiliaresporlote extends GXProcedure
{
   public generarconceptosauxiliaresporlote( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( generarconceptosauxiliaresporlote.class ), "" );
   }

   public generarconceptosauxiliaresporlote( int remoteHandle ,
                                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        GXSimpleCollection<Integer> aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             GXSimpleCollection<Integer> aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 )
   {
      generarconceptosauxiliaresporlote.this.AV8CliCod = aP0;
      generarconceptosauxiliaresporlote.this.AV9EmpCod = aP1;
      generarconceptosauxiliaresporlote.this.AV10LegNumero = aP2;
      generarconceptosauxiliaresporlote.this.AV11LiqNro = aP3;
      generarconceptosauxiliaresporlote.this.AV12ClientId = aP4;
      generarconceptosauxiliaresporlote.this.AV27LiqLote = aP5;
      generarconceptosauxiliaresporlote.this.AV28palabra = aP6;
      generarconceptosauxiliaresporlote.this.AV45daemonUUID = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV49Pgmname, "1") ;
      GXv_char1[0] = AV46flujoPalabra ;
      new web.getparametroflujogenrec(remoteHandle, context).execute( AV8CliCod, GXv_char1) ;
      generarconceptosauxiliaresporlote.this.AV46flujoPalabra = GXv_char1[0] ;
      if ( ( GXutil.strcmp(AV28palabra, httpContext.getMessage( "DEPENDENCIAS_LSD", "")) != 0 ) || ( GXutil.strcmp(AV46flujoPalabra, "1") == 0 ) )
      {
         AV44valor = (short)(1) ;
         /* Execute user subroutine: 'GRABAR LOTE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV49Pgmname, "2") ;
      if ( GXutil.strcmp(AV28palabra, httpContext.getMessage( "DEPENDENCIAS_LSD", "")) != 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV49Pgmname, "3") ;
         GXv_boolean2[0] = AV20revividosTiene ;
         new web.revivirapendientestodos(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11LiqNro, AV10LegNumero, GXv_boolean2) ;
         generarconceptosauxiliaresporlote.this.AV20revividosTiene = GXv_boolean2[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV49Pgmname, "4") ;
      }
      AV16LiqAuxEstado = (byte)(3) ;
      if ( GXutil.strcmp(AV28palabra, httpContext.getMessage( "DEPENDENCIAS_LSD", "")) == 0 )
      {
         AV23ultimoLiqDSecuencial = 1000 ;
      }
      else if ( GXutil.strcmp(AV28palabra, httpContext.getMessage( "CONTRIBUCIONES", "")) == 0 )
      {
         AV23ultimoLiqDSecuencial = 2000 ;
      }
      else
      {
         AV23ultimoLiqDSecuencial = 3000 ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV49Pgmname, "5") ;
      GXv_char1[0] = AV42TLiqCod ;
      GXv_date3[0] = AV43LiqPeriodo ;
      new web.gettipoliqyper(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11LiqNro, GXv_char1, GXv_date3) ;
      generarconceptosauxiliaresporlote.this.AV42TLiqCod = GXv_char1[0] ;
      generarconceptosauxiliaresporlote.this.AV43LiqPeriodo = GXv_date3[0] ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV49Pgmname, "6") ;
      AV38i = (short)(1) ;
      while ( AV38i <= AV10LegNumero.size() )
      {
         AV37auxLegNumero = ((Number) AV10LegNumero.elementAt(-1+AV38i)).intValue() ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV49Pgmname, httpContext.getMessage( "1 &CliCod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( "&EmpCod ", "")+GXutil.trim( GXutil.str( AV9EmpCod, 4, 0))+httpContext.getMessage( " &LiqNro ", "")+GXutil.trim( GXutil.str( AV11LiqNro, 8, 0))+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( AV10LegNumero.toJSonString(false))) ;
         AV40item = (web.Sdtsdt_leg_aux_sdt_leg_auxItem)new web.Sdtsdt_leg_aux_sdt_leg_auxItem(remoteHandle, context);
         AV40item.setgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Legnumero( AV37auxLegNumero );
         AV23ultimoLiqDSecuencial = (int)(AV23ultimoLiqDSecuencial+1) ;
         AV36LiqLegAuxEstado = (byte)(1) ;
         AV41LiqLegErrorAux = "" ;
         AV19resolver = true ;
         GXv_char1[0] = "" ;
         GXv_boolean2[0] = AV22tienePendientes ;
         GXv_objcol_char4[0] = AV21segundo_plano ;
         GXv_int5[0] = AV17LiqDSecuencial ;
         GXv_boolean6[0] = AV13conceptosOK ;
         new web.genconcepsegundoplano(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11LiqNro, AV42TLiqCod, AV37auxLegNumero, true, AV43LiqPeriodo, AV23ultimoLiqDSecuencial, AV19resolver, AV28palabra, GXv_char1, GXv_boolean2, GXv_objcol_char4, GXv_int5, GXv_boolean6) ;
         generarconceptosauxiliaresporlote.this.AV22tienePendientes = GXv_boolean2[0] ;
         AV21segundo_plano = GXv_objcol_char4[0] ;
         generarconceptosauxiliaresporlote.this.AV17LiqDSecuencial = GXv_int5[0] ;
         generarconceptosauxiliaresporlote.this.AV13conceptosOK = GXv_boolean6[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV49Pgmname, httpContext.getMessage( "liqlote ", "")+GXutil.trim( AV27LiqLote)+httpContext.getMessage( " palabra ", "")+GXutil.trim( AV28palabra)+httpContext.getMessage( " !&conceptosOK ", "")+GXutil.trim( GXutil.booltostr( AV13conceptosOK))+httpContext.getMessage( " &tienePendientes ", "")+GXutil.trim( GXutil.booltostr( AV22tienePendientes))+httpContext.getMessage( " &revividosTiene ", "")+GXutil.trim( GXutil.booltostr( AV20revividosTiene))) ;
         if ( ! AV13conceptosOK && ! AV22tienePendientes )
         {
            GXt_char7 = AV41LiqLegErrorAux ;
            GXv_char1[0] = GXt_char7 ;
            new web.textoerrorgeneralliq(remoteHandle, context).execute( AV8CliCod, GXv_char1) ;
            generarconceptosauxiliaresporlote.this.GXt_char7 = GXv_char1[0] ;
            AV41LiqLegErrorAux = GXt_char7 ;
            AV36LiqLegAuxEstado = (byte)(2) ;
            AV16LiqAuxEstado = (byte)(2) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV49Pgmname, httpContext.getMessage( "setea error 1", "")) ;
         }
         else
         {
            if ( ( AV22tienePendientes ) || ( AV20revividosTiene ) )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV49Pgmname, "1!") ;
               GXv_boolean6[0] = AV14errorCiclicoHay ;
               new web.procliquidacion2(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11LiqNro, AV37auxLegNumero, (byte)(1), AV49Pgmname, false, AV28palabra, GXv_boolean6) ;
               generarconceptosauxiliaresporlote.this.AV14errorCiclicoHay = GXv_boolean6[0] ;
               if ( AV14errorCiclicoHay )
               {
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV49Pgmname, httpContext.getMessage( "chau", "")) ;
                  GXt_char7 = AV41LiqLegErrorAux ;
                  GXv_char1[0] = GXt_char7 ;
                  new web.textoerrorciclico(remoteHandle, context).execute( AV8CliCod, GXv_char1) ;
                  generarconceptosauxiliaresporlote.this.GXt_char7 = GXv_char1[0] ;
                  AV41LiqLegErrorAux = GXt_char7 ;
                  AV36LiqLegAuxEstado = (byte)(2) ;
                  AV16LiqAuxEstado = (byte)(2) ;
               }
               else
               {
                  AV36LiqLegAuxEstado = (byte)(3) ;
                  AV41LiqLegErrorAux = "" ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV49Pgmname, httpContext.getMessage( "setea ok 1", "")) ;
               }
            }
            else
            {
               AV36LiqLegAuxEstado = (byte)(3) ;
               AV41LiqLegErrorAux = "" ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV49Pgmname, httpContext.getMessage( "setea ok 2", "")) ;
            }
         }
         if ( ( AV36LiqLegAuxEstado == 3 ) && ( GXutil.strcmp(AV28palabra, httpContext.getMessage( "CONTRIBUCIONES", "")) == 0 ) )
         {
            GXv_decimal8[0] = AV18LiqLegImpContr ;
            new web.liqlegsumarcontribuciones(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11LiqNro, AV37auxLegNumero, GXv_decimal8) ;
            generarconceptosauxiliaresporlote.this.AV18LiqLegImpContr = GXv_decimal8[0] ;
            AV40item.setgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegimpcontr( AV18LiqLegImpContr );
         }
         AV40item.setgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegauxestado( AV36LiqLegAuxEstado );
         AV40item.setgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegerroraux( AV41LiqLegErrorAux );
         AV39sdt_leg_aux.add(AV40item, 0);
         AV38i = (short)(AV38i+1) ;
      }
      if ( AV16LiqAuxEstado == 2 )
      {
         AV29error = httpContext.getMessage( "Error", "") ;
      }
      if ( ( GXutil.strcmp(AV28palabra, httpContext.getMessage( "DEPENDENCIAS_LSD", "")) != 0 ) || ( GXutil.strcmp(AV46flujoPalabra, "1") == 0 ) )
      {
         AV44valor = (short)(2) ;
         /* Execute user subroutine: 'GRABAR LOTE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      AV50GXV1 = 1 ;
      while ( AV50GXV1 <= AV39sdt_leg_aux.size() )
      {
         AV40item = (web.Sdtsdt_leg_aux_sdt_leg_auxItem)((web.Sdtsdt_leg_aux_sdt_leg_auxItem)AV39sdt_leg_aux.elementAt(-1+AV50GXV1));
         AV37auxLegNumero = AV40item.getgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Legnumero() ;
         AV51GXLvl130 = (byte)(0) ;
         /* Using cursor P02B22 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV11LiqNro), Integer.valueOf(AV37auxLegNumero)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A6LegNumero = P02B22_A6LegNumero[0] ;
            A31LiqNro = P02B22_A31LiqNro[0] ;
            A1EmpCod = P02B22_A1EmpCod[0] ;
            A3CliCod = P02B22_A3CliCod[0] ;
            A1780LiqLegAuxEstado = P02B22_A1780LiqLegAuxEstado[0] ;
            A1781LiqLegErrorAux = P02B22_A1781LiqLegErrorAux[0] ;
            A2400LiqLegLSD = P02B22_A2400LiqLegLSD[0] ;
            AV51GXLvl130 = (byte)(1) ;
            A1780LiqLegAuxEstado = AV40item.getgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegauxestado() ;
            A1781LiqLegErrorAux = AV40item.getgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegerroraux() ;
            if ( GXutil.strcmp(AV28palabra, httpContext.getMessage( "DEPENDENCIAS_LSD", "")) == 0 )
            {
               A2400LiqLegLSD = (byte)(1) ;
            }
            /* Using cursor P02B23 */
            pr_default.execute(1, new Object[] {Byte.valueOf(A1780LiqLegAuxEstado), A1781LiqLegErrorAux, Byte.valueOf(A2400LiqLegLSD), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         if ( AV51GXLvl130 == 0 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV49Pgmname, httpContext.getMessage( "nnnn2n!!!!!", "")) ;
         }
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV40item.getgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegimpcontr())==0) )
         {
            AV52GXLvl145 = (byte)(0) ;
            /* Optimized UPDATE. */
            /* Using cursor P02B24 */
            pr_default.execute(2, new Object[] {AV40item.getgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegimpcontr(), Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV11LiqNro), Integer.valueOf(AV37auxLegNumero)});
            if ( (pr_default.getStatus(2) != 101) )
            {
               AV52GXLvl145 = (byte)(1) ;
            }
            Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
            /* End optimized UPDATE. */
            if ( AV52GXLvl145 == 0 )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV49Pgmname, httpContext.getMessage( "nnnn33333333n!!!!!", "")) ;
            }
         }
         AV50GXV1 = (int)(AV50GXV1+1) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'GRABAR LOTE' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV29error)==0) )
      {
         AV29error += " (" + GXutil.trim( AV49Pgmname) + ")" ;
      }
      new web.grabaliquidacionlote(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11LiqNro, AV27LiqLote, AV28palabra, AV44valor, AV29error, AV10LegNumero, AV45daemonUUID) ;
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "generarconceptosauxiliaresporlote");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV49Pgmname = "" ;
      AV46flujoPalabra = "" ;
      AV42TLiqCod = "" ;
      AV43LiqPeriodo = GXutil.nullDate() ;
      GXv_date3 = new java.util.Date[1] ;
      AV40item = new web.Sdtsdt_leg_aux_sdt_leg_auxItem(remoteHandle, context);
      AV41LiqLegErrorAux = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV21segundo_plano = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char4 = new GXSimpleCollection[1] ;
      GXv_int5 = new int[1] ;
      GXv_boolean6 = new boolean[1] ;
      GXt_char7 = "" ;
      GXv_char1 = new String[1] ;
      AV18LiqLegImpContr = DecimalUtil.ZERO ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      AV39sdt_leg_aux = new GXBaseCollection<web.Sdtsdt_leg_aux_sdt_leg_auxItem>(web.Sdtsdt_leg_aux_sdt_leg_auxItem.class, "sdt_leg_auxItem", "PayDay", remoteHandle);
      AV29error = "" ;
      scmdbuf = "" ;
      P02B22_A6LegNumero = new int[1] ;
      P02B22_A31LiqNro = new int[1] ;
      P02B22_A1EmpCod = new short[1] ;
      P02B22_A3CliCod = new int[1] ;
      P02B22_A1780LiqLegAuxEstado = new byte[1] ;
      P02B22_A1781LiqLegErrorAux = new String[] {""} ;
      P02B22_A2400LiqLegLSD = new byte[1] ;
      A1781LiqLegErrorAux = "" ;
      A1157LiqLegImpContr = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.generarconceptosauxiliaresporlote__default(),
         new Object[] {
             new Object[] {
            P02B22_A6LegNumero, P02B22_A31LiqNro, P02B22_A1EmpCod, P02B22_A3CliCod, P02B22_A1780LiqLegAuxEstado, P02B22_A1781LiqLegErrorAux, P02B22_A2400LiqLegLSD
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV49Pgmname = "generarConceptosAuxiliaresPorLote" ;
      /* GeneXus formulas. */
      AV49Pgmname = "generarConceptosAuxiliaresPorLote" ;
      Gx_err = (short)(0) ;
   }

   private byte AV16LiqAuxEstado ;
   private byte AV36LiqLegAuxEstado ;
   private byte AV51GXLvl130 ;
   private byte A1780LiqLegAuxEstado ;
   private byte A2400LiqLegLSD ;
   private byte AV52GXLvl145 ;
   private short AV9EmpCod ;
   private short AV44valor ;
   private short AV38i ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV11LiqNro ;
   private int AV23ultimoLiqDSecuencial ;
   private int AV37auxLegNumero ;
   private int AV17LiqDSecuencial ;
   private int GXv_int5[] ;
   private int AV50GXV1 ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private java.math.BigDecimal AV18LiqLegImpContr ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private java.math.BigDecimal A1157LiqLegImpContr ;
   private String AV28palabra ;
   private String AV45daemonUUID ;
   private String AV49Pgmname ;
   private String AV46flujoPalabra ;
   private String AV42TLiqCod ;
   private String GXt_char7 ;
   private String GXv_char1[] ;
   private String scmdbuf ;
   private java.util.Date AV43LiqPeriodo ;
   private java.util.Date GXv_date3[] ;
   private boolean returnInSub ;
   private boolean AV20revividosTiene ;
   private boolean AV19resolver ;
   private boolean AV22tienePendientes ;
   private boolean GXv_boolean2[] ;
   private boolean AV13conceptosOK ;
   private boolean AV14errorCiclicoHay ;
   private boolean GXv_boolean6[] ;
   private String AV12ClientId ;
   private String AV27LiqLote ;
   private String AV41LiqLegErrorAux ;
   private String AV29error ;
   private String A1781LiqLegErrorAux ;
   private GXSimpleCollection<Integer> AV10LegNumero ;
   private IDataStoreProvider pr_default ;
   private int[] P02B22_A6LegNumero ;
   private int[] P02B22_A31LiqNro ;
   private short[] P02B22_A1EmpCod ;
   private int[] P02B22_A3CliCod ;
   private byte[] P02B22_A1780LiqLegAuxEstado ;
   private String[] P02B22_A1781LiqLegErrorAux ;
   private byte[] P02B22_A2400LiqLegLSD ;
   private GXSimpleCollection<String> AV21segundo_plano ;
   private GXSimpleCollection<String> GXv_objcol_char4[] ;
   private GXBaseCollection<web.Sdtsdt_leg_aux_sdt_leg_auxItem> AV39sdt_leg_aux ;
   private web.Sdtsdt_leg_aux_sdt_leg_auxItem AV40item ;
}

final  class generarconceptosauxiliaresporlote__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02B22", "SELECT LegNumero, LiqNro, EmpCod, CliCod, LiqLegAuxEstado, LiqLegErrorAux, LiqLegLSD FROM LiquidacionLegajo WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LiqNro, LegNumero  FOR UPDATE OF LiquidacionLegajo",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P02B23", "SAVEPOINT gxupdate;UPDATE LiquidacionLegajo SET LiqLegAuxEstado=?, LiqLegErrorAux=?, LiqLegLSD=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P02B24", "UPDATE LiquidacionLegajo SET LiqLegImpContr=?  WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 1 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               return;
            case 2 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
      }
   }

}

