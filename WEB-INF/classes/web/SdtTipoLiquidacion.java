package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtTipoLiquidacion extends GxSilentTrnSdt
{
   public SdtTipoLiquidacion( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtTipoLiquidacion.class));
   }

   public SdtTipoLiquidacion( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle, context, "SdtTipoLiquidacion");
      initialize( remoteHandle) ;
   }

   public SdtTipoLiquidacion( int remoteHandle ,
                              StructSdtTipoLiquidacion struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public void Load( int AV3CliCod ,
                     String AV32TLiqCod )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),AV32TLiqCod});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"TLiqCod", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "TipoLiquidacion");
      metadata.set("BT", "TipoLiquidacion");
      metadata.set("PK", "[ \"CliCod\",\"TLiqCod\" ]");
      metadata.set("PKAssigned", "[ \"CliCod\" ]");
      metadata.set("Levels", "[ \"modo_frec\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] } ]");
      metadata.set("AllowInsert", "True");
      metadata.set("AllowUpdate", "True");
      metadata.set("AllowDelete", "True");
      return metadata ;
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod") )
            {
               gxTv_SdtTipoLiquidacion_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqCod") )
            {
               gxTv_SdtTipoLiquidacion_Tliqcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TliqDesc") )
            {
               gxTv_SdtTipoLiquidacion_Tliqdesc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqHabilitada") )
            {
               gxTv_SdtTipoLiquidacion_Tliqhabilitada = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqAcuDiasTrab") )
            {
               gxTv_SdtTipoLiquidacion_Tliqacudiastrab = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TliqSAC") )
            {
               gxTv_SdtTipoLiquidacion_Tliqsac = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqOrd") )
            {
               gxTv_SdtTipoLiquidacion_Tliqord = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqCodFor") )
            {
               gxTv_SdtTipoLiquidacion_Tliqcodfor = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "modo_frec") )
            {
               if ( gxTv_SdtTipoLiquidacion_Modo_frec == null )
               {
                  gxTv_SdtTipoLiquidacion_Modo_frec = new GXBCLevelCollection<web.SdtTipoLiquidacion_modo_frec>(web.SdtTipoLiquidacion_modo_frec.class, "TipoLiquidacion.modo_frec", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtTipoLiquidacion_Modo_frec.readxml(oReader, "modo_frec") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "modo_frec") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtTipoLiquidacion_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtTipoLiquidacion_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_SdtTipoLiquidacion_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqCod_Z") )
            {
               gxTv_SdtTipoLiquidacion_Tliqcod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TliqDesc_Z") )
            {
               gxTv_SdtTipoLiquidacion_Tliqdesc_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqHabilitada_Z") )
            {
               gxTv_SdtTipoLiquidacion_Tliqhabilitada_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqAcuDiasTrab_Z") )
            {
               gxTv_SdtTipoLiquidacion_Tliqacudiastrab_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TliqSAC_Z") )
            {
               gxTv_SdtTipoLiquidacion_Tliqsac_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqOrd_Z") )
            {
               gxTv_SdtTipoLiquidacion_Tliqord_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqCodFor_Z") )
            {
               gxTv_SdtTipoLiquidacion_Tliqcodfor_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqCod_N") )
            {
               gxTv_SdtTipoLiquidacion_Tliqcod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "TipoLiquidacion" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "PayDay" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_SdtTipoLiquidacion_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TLiqCod", gxTv_SdtTipoLiquidacion_Tliqcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TliqDesc", gxTv_SdtTipoLiquidacion_Tliqdesc);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TLiqHabilitada", GXutil.booltostr( gxTv_SdtTipoLiquidacion_Tliqhabilitada));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TLiqAcuDiasTrab", GXutil.booltostr( gxTv_SdtTipoLiquidacion_Tliqacudiastrab));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TliqSAC", GXutil.booltostr( gxTv_SdtTipoLiquidacion_Tliqsac));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TLiqOrd", GXutil.trim( GXutil.str( gxTv_SdtTipoLiquidacion_Tliqord, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TLiqCodFor", gxTv_SdtTipoLiquidacion_Tliqcodfor);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_SdtTipoLiquidacion_Modo_frec != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "PayDay") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "PayDay" ;
         }
         else
         {
            sNameSpace1 = "PayDay" ;
         }
         gxTv_SdtTipoLiquidacion_Modo_frec.writexml(oWriter, "modo_frec", sNameSpace1, sIncludeState);
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtTipoLiquidacion_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtTipoLiquidacion_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtTipoLiquidacion_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TLiqCod_Z", gxTv_SdtTipoLiquidacion_Tliqcod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TliqDesc_Z", gxTv_SdtTipoLiquidacion_Tliqdesc_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TLiqHabilitada_Z", GXutil.booltostr( gxTv_SdtTipoLiquidacion_Tliqhabilitada_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TLiqAcuDiasTrab_Z", GXutil.booltostr( gxTv_SdtTipoLiquidacion_Tliqacudiastrab_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TliqSAC_Z", GXutil.booltostr( gxTv_SdtTipoLiquidacion_Tliqsac_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TLiqOrd_Z", GXutil.trim( GXutil.str( gxTv_SdtTipoLiquidacion_Tliqord_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TLiqCodFor_Z", gxTv_SdtTipoLiquidacion_Tliqcodfor_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TLiqCod_N", GXutil.trim( GXutil.str( gxTv_SdtTipoLiquidacion_Tliqcod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("CliCod", gxTv_SdtTipoLiquidacion_Clicod, false, includeNonInitialized);
      AddObjectProperty("TLiqCod", gxTv_SdtTipoLiquidacion_Tliqcod, false, includeNonInitialized);
      AddObjectProperty("TLiqCod_N", gxTv_SdtTipoLiquidacion_Tliqcod_N, false, includeNonInitialized);
      AddObjectProperty("TliqDesc", gxTv_SdtTipoLiquidacion_Tliqdesc, false, includeNonInitialized);
      AddObjectProperty("TLiqHabilitada", gxTv_SdtTipoLiquidacion_Tliqhabilitada, false, includeNonInitialized);
      AddObjectProperty("TLiqAcuDiasTrab", gxTv_SdtTipoLiquidacion_Tliqacudiastrab, false, includeNonInitialized);
      AddObjectProperty("TliqSAC", gxTv_SdtTipoLiquidacion_Tliqsac, false, includeNonInitialized);
      AddObjectProperty("TLiqOrd", gxTv_SdtTipoLiquidacion_Tliqord, false, includeNonInitialized);
      AddObjectProperty("TLiqCodFor", gxTv_SdtTipoLiquidacion_Tliqcodfor, false, includeNonInitialized);
      if ( gxTv_SdtTipoLiquidacion_Modo_frec != null )
      {
         AddObjectProperty("modo_frec", gxTv_SdtTipoLiquidacion_Modo_frec, includeState, includeNonInitialized);
      }
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtTipoLiquidacion_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtTipoLiquidacion_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_SdtTipoLiquidacion_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("TLiqCod_Z", gxTv_SdtTipoLiquidacion_Tliqcod_Z, false, includeNonInitialized);
         AddObjectProperty("TliqDesc_Z", gxTv_SdtTipoLiquidacion_Tliqdesc_Z, false, includeNonInitialized);
         AddObjectProperty("TLiqHabilitada_Z", gxTv_SdtTipoLiquidacion_Tliqhabilitada_Z, false, includeNonInitialized);
         AddObjectProperty("TLiqAcuDiasTrab_Z", gxTv_SdtTipoLiquidacion_Tliqacudiastrab_Z, false, includeNonInitialized);
         AddObjectProperty("TliqSAC_Z", gxTv_SdtTipoLiquidacion_Tliqsac_Z, false, includeNonInitialized);
         AddObjectProperty("TLiqOrd_Z", gxTv_SdtTipoLiquidacion_Tliqord_Z, false, includeNonInitialized);
         AddObjectProperty("TLiqCodFor_Z", gxTv_SdtTipoLiquidacion_Tliqcodfor_Z, false, includeNonInitialized);
         AddObjectProperty("TLiqCod_N", gxTv_SdtTipoLiquidacion_Tliqcod_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtTipoLiquidacion sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
         gxTv_SdtTipoLiquidacion_Clicod = sdt.getgxTv_SdtTipoLiquidacion_Clicod() ;
      }
      if ( sdt.IsDirty("TLiqCod") )
      {
         gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
         gxTv_SdtTipoLiquidacion_Tliqcod = sdt.getgxTv_SdtTipoLiquidacion_Tliqcod() ;
      }
      if ( sdt.IsDirty("TliqDesc") )
      {
         gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
         gxTv_SdtTipoLiquidacion_Tliqdesc = sdt.getgxTv_SdtTipoLiquidacion_Tliqdesc() ;
      }
      if ( sdt.IsDirty("TLiqHabilitada") )
      {
         gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
         gxTv_SdtTipoLiquidacion_Tliqhabilitada = sdt.getgxTv_SdtTipoLiquidacion_Tliqhabilitada() ;
      }
      if ( sdt.IsDirty("TLiqAcuDiasTrab") )
      {
         gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
         gxTv_SdtTipoLiquidacion_Tliqacudiastrab = sdt.getgxTv_SdtTipoLiquidacion_Tliqacudiastrab() ;
      }
      if ( sdt.IsDirty("TliqSAC") )
      {
         gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
         gxTv_SdtTipoLiquidacion_Tliqsac = sdt.getgxTv_SdtTipoLiquidacion_Tliqsac() ;
      }
      if ( sdt.IsDirty("TLiqOrd") )
      {
         gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
         gxTv_SdtTipoLiquidacion_Tliqord = sdt.getgxTv_SdtTipoLiquidacion_Tliqord() ;
      }
      if ( sdt.IsDirty("TLiqCodFor") )
      {
         gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
         gxTv_SdtTipoLiquidacion_Tliqcodfor = sdt.getgxTv_SdtTipoLiquidacion_Tliqcodfor() ;
      }
      if ( gxTv_SdtTipoLiquidacion_Modo_frec != null )
      {
         GXBCLevelCollection<web.SdtTipoLiquidacion_modo_frec> newCollectionModo_frec = sdt.getgxTv_SdtTipoLiquidacion_Modo_frec();
         web.SdtTipoLiquidacion_modo_frec currItemModo_frec;
         web.SdtTipoLiquidacion_modo_frec newItemModo_frec;
         short idx = 1;
         while ( idx <= newCollectionModo_frec.size() )
         {
            newItemModo_frec = (web.SdtTipoLiquidacion_modo_frec)((web.SdtTipoLiquidacion_modo_frec)newCollectionModo_frec.elementAt(-1+idx));
            currItemModo_frec = (web.SdtTipoLiquidacion_modo_frec)gxTv_SdtTipoLiquidacion_Modo_frec.getByKey(newItemModo_frec.getgxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra(), newItemModo_frec.getgxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag());
            if ( GXutil.strcmp(currItemModo_frec.getgxTv_SdtTipoLiquidacion_modo_frec_Mode(), "UPD") == 0 )
            {
               currItemModo_frec.updateDirties(newItemModo_frec);
               if ( GXutil.strcmp(newItemModo_frec.getgxTv_SdtTipoLiquidacion_modo_frec_Mode(), "DLT") == 0 )
               {
                  currItemModo_frec.setgxTv_SdtTipoLiquidacion_modo_frec_Mode( "DLT" );
               }
               currItemModo_frec.setgxTv_SdtTipoLiquidacion_modo_frec_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtTipoLiquidacion_Modo_frec.add(newItemModo_frec, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
   }

   public int getgxTv_SdtTipoLiquidacion_Clicod( )
   {
      return gxTv_SdtTipoLiquidacion_Clicod ;
   }

   public void setgxTv_SdtTipoLiquidacion_Clicod( int value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      if ( gxTv_SdtTipoLiquidacion_Clicod != value )
      {
         gxTv_SdtTipoLiquidacion_Mode = "INS" ;
         this.setgxTv_SdtTipoLiquidacion_Clicod_Z_SetNull( );
         this.setgxTv_SdtTipoLiquidacion_Tliqcod_Z_SetNull( );
         this.setgxTv_SdtTipoLiquidacion_Tliqdesc_Z_SetNull( );
         this.setgxTv_SdtTipoLiquidacion_Tliqhabilitada_Z_SetNull( );
         this.setgxTv_SdtTipoLiquidacion_Tliqacudiastrab_Z_SetNull( );
         this.setgxTv_SdtTipoLiquidacion_Tliqsac_Z_SetNull( );
         this.setgxTv_SdtTipoLiquidacion_Tliqord_Z_SetNull( );
         this.setgxTv_SdtTipoLiquidacion_Tliqcodfor_Z_SetNull( );
         if ( gxTv_SdtTipoLiquidacion_Modo_frec != null )
         {
            GXBCLevelCollection<web.SdtTipoLiquidacion_modo_frec> collectionModo_frec = gxTv_SdtTipoLiquidacion_Modo_frec;
            web.SdtTipoLiquidacion_modo_frec currItemModo_frec;
            short idx = 1;
            while ( idx <= collectionModo_frec.size() )
            {
               currItemModo_frec = (web.SdtTipoLiquidacion_modo_frec)((web.SdtTipoLiquidacion_modo_frec)collectionModo_frec.elementAt(-1+idx));
               currItemModo_frec.setgxTv_SdtTipoLiquidacion_modo_frec_Mode( "INS" );
               currItemModo_frec.setgxTv_SdtTipoLiquidacion_modo_frec_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Clicod");
      gxTv_SdtTipoLiquidacion_Clicod = value ;
   }

   public String getgxTv_SdtTipoLiquidacion_Tliqcod( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqcod ;
   }

   public void setgxTv_SdtTipoLiquidacion_Tliqcod( String value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_SdtTipoLiquidacion_Tliqcod, value) != 0 )
      {
         gxTv_SdtTipoLiquidacion_Mode = "INS" ;
         this.setgxTv_SdtTipoLiquidacion_Clicod_Z_SetNull( );
         this.setgxTv_SdtTipoLiquidacion_Tliqcod_Z_SetNull( );
         this.setgxTv_SdtTipoLiquidacion_Tliqdesc_Z_SetNull( );
         this.setgxTv_SdtTipoLiquidacion_Tliqhabilitada_Z_SetNull( );
         this.setgxTv_SdtTipoLiquidacion_Tliqacudiastrab_Z_SetNull( );
         this.setgxTv_SdtTipoLiquidacion_Tliqsac_Z_SetNull( );
         this.setgxTv_SdtTipoLiquidacion_Tliqord_Z_SetNull( );
         this.setgxTv_SdtTipoLiquidacion_Tliqcodfor_Z_SetNull( );
         if ( gxTv_SdtTipoLiquidacion_Modo_frec != null )
         {
            GXBCLevelCollection<web.SdtTipoLiquidacion_modo_frec> collectionModo_frec = gxTv_SdtTipoLiquidacion_Modo_frec;
            web.SdtTipoLiquidacion_modo_frec currItemModo_frec;
            short idx = 1;
            while ( idx <= collectionModo_frec.size() )
            {
               currItemModo_frec = (web.SdtTipoLiquidacion_modo_frec)((web.SdtTipoLiquidacion_modo_frec)collectionModo_frec.elementAt(-1+idx));
               currItemModo_frec.setgxTv_SdtTipoLiquidacion_modo_frec_Mode( "INS" );
               currItemModo_frec.setgxTv_SdtTipoLiquidacion_modo_frec_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Tliqcod");
      gxTv_SdtTipoLiquidacion_Tliqcod = value ;
   }

   public String getgxTv_SdtTipoLiquidacion_Tliqdesc( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqdesc ;
   }

   public void setgxTv_SdtTipoLiquidacion_Tliqdesc( String value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      SetDirty("Tliqdesc");
      gxTv_SdtTipoLiquidacion_Tliqdesc = value ;
   }

   public boolean getgxTv_SdtTipoLiquidacion_Tliqhabilitada( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqhabilitada ;
   }

   public void setgxTv_SdtTipoLiquidacion_Tliqhabilitada( boolean value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      SetDirty("Tliqhabilitada");
      gxTv_SdtTipoLiquidacion_Tliqhabilitada = value ;
   }

   public boolean getgxTv_SdtTipoLiquidacion_Tliqacudiastrab( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqacudiastrab ;
   }

   public void setgxTv_SdtTipoLiquidacion_Tliqacudiastrab( boolean value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      SetDirty("Tliqacudiastrab");
      gxTv_SdtTipoLiquidacion_Tliqacudiastrab = value ;
   }

   public boolean getgxTv_SdtTipoLiquidacion_Tliqsac( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqsac ;
   }

   public void setgxTv_SdtTipoLiquidacion_Tliqsac( boolean value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      SetDirty("Tliqsac");
      gxTv_SdtTipoLiquidacion_Tliqsac = value ;
   }

   public short getgxTv_SdtTipoLiquidacion_Tliqord( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqord ;
   }

   public void setgxTv_SdtTipoLiquidacion_Tliqord( short value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      SetDirty("Tliqord");
      gxTv_SdtTipoLiquidacion_Tliqord = value ;
   }

   public String getgxTv_SdtTipoLiquidacion_Tliqcodfor( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqcodfor ;
   }

   public void setgxTv_SdtTipoLiquidacion_Tliqcodfor( String value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      SetDirty("Tliqcodfor");
      gxTv_SdtTipoLiquidacion_Tliqcodfor = value ;
   }

   public GXBCLevelCollection<web.SdtTipoLiquidacion_modo_frec> getgxTv_SdtTipoLiquidacion_Modo_frec( )
   {
      if ( gxTv_SdtTipoLiquidacion_Modo_frec == null )
      {
         gxTv_SdtTipoLiquidacion_Modo_frec = new GXBCLevelCollection<web.SdtTipoLiquidacion_modo_frec>(web.SdtTipoLiquidacion_modo_frec.class, "TipoLiquidacion.modo_frec", "PayDay", remoteHandle);
      }
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      return gxTv_SdtTipoLiquidacion_Modo_frec ;
   }

   public void setgxTv_SdtTipoLiquidacion_Modo_frec( GXBCLevelCollection<web.SdtTipoLiquidacion_modo_frec> value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      SetDirty("Modo_frec");
      gxTv_SdtTipoLiquidacion_Modo_frec = value ;
   }

   public void setgxTv_SdtTipoLiquidacion_Modo_frec_SetNull( )
   {
      gxTv_SdtTipoLiquidacion_Modo_frec = null ;
      SetDirty("Modo_frec");
   }

   public boolean getgxTv_SdtTipoLiquidacion_Modo_frec_IsNull( )
   {
      if ( gxTv_SdtTipoLiquidacion_Modo_frec == null )
      {
         return true ;
      }
      return false ;
   }

   public String getgxTv_SdtTipoLiquidacion_Mode( )
   {
      return gxTv_SdtTipoLiquidacion_Mode ;
   }

   public void setgxTv_SdtTipoLiquidacion_Mode( String value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtTipoLiquidacion_Mode = value ;
   }

   public void setgxTv_SdtTipoLiquidacion_Mode_SetNull( )
   {
      gxTv_SdtTipoLiquidacion_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtTipoLiquidacion_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtTipoLiquidacion_Initialized( )
   {
      return gxTv_SdtTipoLiquidacion_Initialized ;
   }

   public void setgxTv_SdtTipoLiquidacion_Initialized( short value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtTipoLiquidacion_Initialized = value ;
   }

   public void setgxTv_SdtTipoLiquidacion_Initialized_SetNull( )
   {
      gxTv_SdtTipoLiquidacion_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtTipoLiquidacion_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtTipoLiquidacion_Clicod_Z( )
   {
      return gxTv_SdtTipoLiquidacion_Clicod_Z ;
   }

   public void setgxTv_SdtTipoLiquidacion_Clicod_Z( int value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_SdtTipoLiquidacion_Clicod_Z = value ;
   }

   public void setgxTv_SdtTipoLiquidacion_Clicod_Z_SetNull( )
   {
      gxTv_SdtTipoLiquidacion_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_SdtTipoLiquidacion_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtTipoLiquidacion_Tliqcod_Z( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqcod_Z ;
   }

   public void setgxTv_SdtTipoLiquidacion_Tliqcod_Z( String value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      SetDirty("Tliqcod_Z");
      gxTv_SdtTipoLiquidacion_Tliqcod_Z = value ;
   }

   public void setgxTv_SdtTipoLiquidacion_Tliqcod_Z_SetNull( )
   {
      gxTv_SdtTipoLiquidacion_Tliqcod_Z = "" ;
      SetDirty("Tliqcod_Z");
   }

   public boolean getgxTv_SdtTipoLiquidacion_Tliqcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtTipoLiquidacion_Tliqdesc_Z( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqdesc_Z ;
   }

   public void setgxTv_SdtTipoLiquidacion_Tliqdesc_Z( String value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      SetDirty("Tliqdesc_Z");
      gxTv_SdtTipoLiquidacion_Tliqdesc_Z = value ;
   }

   public void setgxTv_SdtTipoLiquidacion_Tliqdesc_Z_SetNull( )
   {
      gxTv_SdtTipoLiquidacion_Tliqdesc_Z = "" ;
      SetDirty("Tliqdesc_Z");
   }

   public boolean getgxTv_SdtTipoLiquidacion_Tliqdesc_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtTipoLiquidacion_Tliqhabilitada_Z( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqhabilitada_Z ;
   }

   public void setgxTv_SdtTipoLiquidacion_Tliqhabilitada_Z( boolean value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      SetDirty("Tliqhabilitada_Z");
      gxTv_SdtTipoLiquidacion_Tliqhabilitada_Z = value ;
   }

   public void setgxTv_SdtTipoLiquidacion_Tliqhabilitada_Z_SetNull( )
   {
      gxTv_SdtTipoLiquidacion_Tliqhabilitada_Z = false ;
      SetDirty("Tliqhabilitada_Z");
   }

   public boolean getgxTv_SdtTipoLiquidacion_Tliqhabilitada_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtTipoLiquidacion_Tliqacudiastrab_Z( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqacudiastrab_Z ;
   }

   public void setgxTv_SdtTipoLiquidacion_Tliqacudiastrab_Z( boolean value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      SetDirty("Tliqacudiastrab_Z");
      gxTv_SdtTipoLiquidacion_Tliqacudiastrab_Z = value ;
   }

   public void setgxTv_SdtTipoLiquidacion_Tliqacudiastrab_Z_SetNull( )
   {
      gxTv_SdtTipoLiquidacion_Tliqacudiastrab_Z = false ;
      SetDirty("Tliqacudiastrab_Z");
   }

   public boolean getgxTv_SdtTipoLiquidacion_Tliqacudiastrab_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtTipoLiquidacion_Tliqsac_Z( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqsac_Z ;
   }

   public void setgxTv_SdtTipoLiquidacion_Tliqsac_Z( boolean value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      SetDirty("Tliqsac_Z");
      gxTv_SdtTipoLiquidacion_Tliqsac_Z = value ;
   }

   public void setgxTv_SdtTipoLiquidacion_Tliqsac_Z_SetNull( )
   {
      gxTv_SdtTipoLiquidacion_Tliqsac_Z = false ;
      SetDirty("Tliqsac_Z");
   }

   public boolean getgxTv_SdtTipoLiquidacion_Tliqsac_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtTipoLiquidacion_Tliqord_Z( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqord_Z ;
   }

   public void setgxTv_SdtTipoLiquidacion_Tliqord_Z( short value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      SetDirty("Tliqord_Z");
      gxTv_SdtTipoLiquidacion_Tliqord_Z = value ;
   }

   public void setgxTv_SdtTipoLiquidacion_Tliqord_Z_SetNull( )
   {
      gxTv_SdtTipoLiquidacion_Tliqord_Z = (short)(0) ;
      SetDirty("Tliqord_Z");
   }

   public boolean getgxTv_SdtTipoLiquidacion_Tliqord_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtTipoLiquidacion_Tliqcodfor_Z( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqcodfor_Z ;
   }

   public void setgxTv_SdtTipoLiquidacion_Tliqcodfor_Z( String value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      SetDirty("Tliqcodfor_Z");
      gxTv_SdtTipoLiquidacion_Tliqcodfor_Z = value ;
   }

   public void setgxTv_SdtTipoLiquidacion_Tliqcodfor_Z_SetNull( )
   {
      gxTv_SdtTipoLiquidacion_Tliqcodfor_Z = "" ;
      SetDirty("Tliqcodfor_Z");
   }

   public boolean getgxTv_SdtTipoLiquidacion_Tliqcodfor_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtTipoLiquidacion_Tliqcod_N( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqcod_N ;
   }

   public void setgxTv_SdtTipoLiquidacion_Tliqcod_N( byte value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      SetDirty("Tliqcod_N");
      gxTv_SdtTipoLiquidacion_Tliqcod_N = value ;
   }

   public void setgxTv_SdtTipoLiquidacion_Tliqcod_N_SetNull( )
   {
      gxTv_SdtTipoLiquidacion_Tliqcod_N = (byte)(0) ;
      SetDirty("Tliqcod_N");
   }

   public boolean getgxTv_SdtTipoLiquidacion_Tliqcod_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.tipoliquidacion_bc obj;
      obj = new web.tipoliquidacion_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(1) ;
      gxTv_SdtTipoLiquidacion_Tliqcod = "" ;
      gxTv_SdtTipoLiquidacion_Tliqdesc = "" ;
      gxTv_SdtTipoLiquidacion_Tliqcodfor = "" ;
      gxTv_SdtTipoLiquidacion_Mode = "" ;
      gxTv_SdtTipoLiquidacion_Tliqcod_Z = "" ;
      gxTv_SdtTipoLiquidacion_Tliqdesc_Z = "" ;
      gxTv_SdtTipoLiquidacion_Tliqcodfor_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtTipoLiquidacion_N ;
   }

   public web.SdtTipoLiquidacion Clone( )
   {
      web.SdtTipoLiquidacion sdt;
      web.tipoliquidacion_bc obj;
      sdt = (web.SdtTipoLiquidacion)(clone()) ;
      obj = (web.tipoliquidacion_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtTipoLiquidacion struct )
   {
      setgxTv_SdtTipoLiquidacion_Clicod(struct.getClicod());
      setgxTv_SdtTipoLiquidacion_Tliqcod(struct.getTliqcod());
      setgxTv_SdtTipoLiquidacion_Tliqdesc(struct.getTliqdesc());
      setgxTv_SdtTipoLiquidacion_Tliqhabilitada(struct.getTliqhabilitada());
      setgxTv_SdtTipoLiquidacion_Tliqacudiastrab(struct.getTliqacudiastrab());
      setgxTv_SdtTipoLiquidacion_Tliqsac(struct.getTliqsac());
      setgxTv_SdtTipoLiquidacion_Tliqord(struct.getTliqord());
      setgxTv_SdtTipoLiquidacion_Tliqcodfor(struct.getTliqcodfor());
      GXBCLevelCollection<web.SdtTipoLiquidacion_modo_frec> gxTv_SdtTipoLiquidacion_Modo_frec_aux = new GXBCLevelCollection<web.SdtTipoLiquidacion_modo_frec>(web.SdtTipoLiquidacion_modo_frec.class, "TipoLiquidacion.modo_frec", "PayDay", remoteHandle);
      Vector<web.StructSdtTipoLiquidacion_modo_frec> gxTv_SdtTipoLiquidacion_Modo_frec_aux1 = struct.getModo_frec();
      if (gxTv_SdtTipoLiquidacion_Modo_frec_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtTipoLiquidacion_Modo_frec_aux1.size(); i++)
         {
            gxTv_SdtTipoLiquidacion_Modo_frec_aux.add(new web.SdtTipoLiquidacion_modo_frec(remoteHandle, gxTv_SdtTipoLiquidacion_Modo_frec_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtTipoLiquidacion_Modo_frec(gxTv_SdtTipoLiquidacion_Modo_frec_aux);
      setgxTv_SdtTipoLiquidacion_Mode(struct.getMode());
      setgxTv_SdtTipoLiquidacion_Initialized(struct.getInitialized());
      setgxTv_SdtTipoLiquidacion_Clicod_Z(struct.getClicod_Z());
      setgxTv_SdtTipoLiquidacion_Tliqcod_Z(struct.getTliqcod_Z());
      setgxTv_SdtTipoLiquidacion_Tliqdesc_Z(struct.getTliqdesc_Z());
      setgxTv_SdtTipoLiquidacion_Tliqhabilitada_Z(struct.getTliqhabilitada_Z());
      setgxTv_SdtTipoLiquidacion_Tliqacudiastrab_Z(struct.getTliqacudiastrab_Z());
      setgxTv_SdtTipoLiquidacion_Tliqsac_Z(struct.getTliqsac_Z());
      setgxTv_SdtTipoLiquidacion_Tliqord_Z(struct.getTliqord_Z());
      setgxTv_SdtTipoLiquidacion_Tliqcodfor_Z(struct.getTliqcodfor_Z());
      setgxTv_SdtTipoLiquidacion_Tliqcod_N(struct.getTliqcod_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtTipoLiquidacion getStruct( )
   {
      web.StructSdtTipoLiquidacion struct = new web.StructSdtTipoLiquidacion ();
      struct.setClicod(getgxTv_SdtTipoLiquidacion_Clicod());
      struct.setTliqcod(getgxTv_SdtTipoLiquidacion_Tliqcod());
      struct.setTliqdesc(getgxTv_SdtTipoLiquidacion_Tliqdesc());
      struct.setTliqhabilitada(getgxTv_SdtTipoLiquidacion_Tliqhabilitada());
      struct.setTliqacudiastrab(getgxTv_SdtTipoLiquidacion_Tliqacudiastrab());
      struct.setTliqsac(getgxTv_SdtTipoLiquidacion_Tliqsac());
      struct.setTliqord(getgxTv_SdtTipoLiquidacion_Tliqord());
      struct.setTliqcodfor(getgxTv_SdtTipoLiquidacion_Tliqcodfor());
      struct.setModo_frec(getgxTv_SdtTipoLiquidacion_Modo_frec().getStruct());
      struct.setMode(getgxTv_SdtTipoLiquidacion_Mode());
      struct.setInitialized(getgxTv_SdtTipoLiquidacion_Initialized());
      struct.setClicod_Z(getgxTv_SdtTipoLiquidacion_Clicod_Z());
      struct.setTliqcod_Z(getgxTv_SdtTipoLiquidacion_Tliqcod_Z());
      struct.setTliqdesc_Z(getgxTv_SdtTipoLiquidacion_Tliqdesc_Z());
      struct.setTliqhabilitada_Z(getgxTv_SdtTipoLiquidacion_Tliqhabilitada_Z());
      struct.setTliqacudiastrab_Z(getgxTv_SdtTipoLiquidacion_Tliqacudiastrab_Z());
      struct.setTliqsac_Z(getgxTv_SdtTipoLiquidacion_Tliqsac_Z());
      struct.setTliqord_Z(getgxTv_SdtTipoLiquidacion_Tliqord_Z());
      struct.setTliqcodfor_Z(getgxTv_SdtTipoLiquidacion_Tliqcodfor_Z());
      struct.setTliqcod_N(getgxTv_SdtTipoLiquidacion_Tliqcod_N());
      return struct ;
   }

   private byte gxTv_SdtTipoLiquidacion_N ;
   private byte gxTv_SdtTipoLiquidacion_Tliqcod_N ;
   private short gxTv_SdtTipoLiquidacion_Tliqord ;
   private short gxTv_SdtTipoLiquidacion_Initialized ;
   private short gxTv_SdtTipoLiquidacion_Tliqord_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtTipoLiquidacion_Clicod ;
   private int gxTv_SdtTipoLiquidacion_Clicod_Z ;
   private String gxTv_SdtTipoLiquidacion_Tliqcod ;
   private String gxTv_SdtTipoLiquidacion_Tliqcodfor ;
   private String gxTv_SdtTipoLiquidacion_Mode ;
   private String gxTv_SdtTipoLiquidacion_Tliqcod_Z ;
   private String gxTv_SdtTipoLiquidacion_Tliqcodfor_Z ;
   private String sTagName ;
   private boolean gxTv_SdtTipoLiquidacion_Tliqhabilitada ;
   private boolean gxTv_SdtTipoLiquidacion_Tliqacudiastrab ;
   private boolean gxTv_SdtTipoLiquidacion_Tliqsac ;
   private boolean gxTv_SdtTipoLiquidacion_Tliqhabilitada_Z ;
   private boolean gxTv_SdtTipoLiquidacion_Tliqacudiastrab_Z ;
   private boolean gxTv_SdtTipoLiquidacion_Tliqsac_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtTipoLiquidacion_Tliqdesc ;
   private String gxTv_SdtTipoLiquidacion_Tliqdesc_Z ;
   private GXBCLevelCollection<web.SdtTipoLiquidacion_modo_frec> gxTv_SdtTipoLiquidacion_Modo_frec_aux ;
   private GXBCLevelCollection<web.SdtTipoLiquidacion_modo_frec> gxTv_SdtTipoLiquidacion_Modo_frec=null ;
}

