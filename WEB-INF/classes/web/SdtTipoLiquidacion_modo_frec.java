package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtTipoLiquidacion_modo_frec extends GxSilentTrnSdt
{
   public SdtTipoLiquidacion_modo_frec( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtTipoLiquidacion_modo_frec.class));
   }

   public SdtTipoLiquidacion_modo_frec( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle, context, "SdtTipoLiquidacion_modo_frec");
      initialize( remoteHandle) ;
   }

   public SdtTipoLiquidacion_modo_frec( int remoteHandle ,
                                        StructSdtTipoLiquidacion_modo_frec struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtTipoLiquidacion_modo_frec( )
   {
      super( new ModelContext(SdtTipoLiquidacion_modo_frec.class), "SdtTipoLiquidacion_modo_frec");
      initialize( ) ;
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"TLiqModTra", String.class}, new Object[]{"TLiqFrecPag", byte.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "modo_frec");
      metadata.set("BT", "TipoLiquidacionmodo_frec");
      metadata.set("PK", "[ \"TLiqModTra\",\"TLiqFrecPag\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\",\"TLiqCod\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqModTra") )
            {
               gxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqFrecPag") )
            {
               gxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqDescAuxFrec") )
            {
               gxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtTipoLiquidacion_modo_frec_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtTipoLiquidacion_modo_frec_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtTipoLiquidacion_modo_frec_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqModTra_Z") )
            {
               gxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqFrecPag_Z") )
            {
               gxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqDescAuxFrec_Z") )
            {
               gxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec_Z = oReader.getValue() ;
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
         sName = "TipoLiquidacion.modo_frec" ;
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
      oWriter.writeElement("TLiqModTra", gxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TLiqFrecPag", GXutil.trim( GXutil.str( gxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TLiqDescAuxFrec", gxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtTipoLiquidacion_modo_frec_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtTipoLiquidacion_modo_frec_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtTipoLiquidacion_modo_frec_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TLiqModTra_Z", gxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TLiqFrecPag_Z", GXutil.trim( GXutil.str( gxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TLiqDescAuxFrec_Z", gxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec_Z);
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
      AddObjectProperty("TLiqModTra", gxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra, false, includeNonInitialized);
      AddObjectProperty("TLiqFrecPag", gxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag, false, includeNonInitialized);
      AddObjectProperty("TLiqDescAuxFrec", gxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtTipoLiquidacion_modo_frec_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtTipoLiquidacion_modo_frec_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtTipoLiquidacion_modo_frec_Initialized, false, includeNonInitialized);
         AddObjectProperty("TLiqModTra_Z", gxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra_Z, false, includeNonInitialized);
         AddObjectProperty("TLiqFrecPag_Z", gxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag_Z, false, includeNonInitialized);
         AddObjectProperty("TLiqDescAuxFrec_Z", gxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtTipoLiquidacion_modo_frec sdt )
   {
      if ( sdt.IsDirty("TLiqModTra") )
      {
         gxTv_SdtTipoLiquidacion_modo_frec_N = (byte)(0) ;
         gxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra = sdt.getgxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra() ;
      }
      if ( sdt.IsDirty("TLiqFrecPag") )
      {
         gxTv_SdtTipoLiquidacion_modo_frec_N = (byte)(0) ;
         gxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag = sdt.getgxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag() ;
      }
      if ( sdt.IsDirty("TLiqDescAuxFrec") )
      {
         gxTv_SdtTipoLiquidacion_modo_frec_N = (byte)(0) ;
         gxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec = sdt.getgxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec() ;
      }
   }

   public String getgxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra( )
   {
      return gxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra ;
   }

   public void setgxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra( String value )
   {
      gxTv_SdtTipoLiquidacion_modo_frec_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_modo_frec_Modified = (short)(1) ;
      SetDirty("Tliqmodtra");
      gxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra = value ;
   }

   public byte getgxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag( )
   {
      return gxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag ;
   }

   public void setgxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag( byte value )
   {
      gxTv_SdtTipoLiquidacion_modo_frec_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_modo_frec_Modified = (short)(1) ;
      SetDirty("Tliqfrecpag");
      gxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag = value ;
   }

   public String getgxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec( )
   {
      return gxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec ;
   }

   public void setgxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec( String value )
   {
      gxTv_SdtTipoLiquidacion_modo_frec_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_modo_frec_Modified = (short)(1) ;
      SetDirty("Tliqdescauxfrec");
      gxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec = value ;
   }

   public String getgxTv_SdtTipoLiquidacion_modo_frec_Mode( )
   {
      return gxTv_SdtTipoLiquidacion_modo_frec_Mode ;
   }

   public void setgxTv_SdtTipoLiquidacion_modo_frec_Mode( String value )
   {
      gxTv_SdtTipoLiquidacion_modo_frec_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtTipoLiquidacion_modo_frec_Mode = value ;
   }

   public void setgxTv_SdtTipoLiquidacion_modo_frec_Mode_SetNull( )
   {
      gxTv_SdtTipoLiquidacion_modo_frec_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtTipoLiquidacion_modo_frec_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtTipoLiquidacion_modo_frec_Modified( )
   {
      return gxTv_SdtTipoLiquidacion_modo_frec_Modified ;
   }

   public void setgxTv_SdtTipoLiquidacion_modo_frec_Modified( short value )
   {
      gxTv_SdtTipoLiquidacion_modo_frec_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtTipoLiquidacion_modo_frec_Modified = value ;
   }

   public void setgxTv_SdtTipoLiquidacion_modo_frec_Modified_SetNull( )
   {
      gxTv_SdtTipoLiquidacion_modo_frec_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtTipoLiquidacion_modo_frec_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtTipoLiquidacion_modo_frec_Initialized( )
   {
      return gxTv_SdtTipoLiquidacion_modo_frec_Initialized ;
   }

   public void setgxTv_SdtTipoLiquidacion_modo_frec_Initialized( short value )
   {
      gxTv_SdtTipoLiquidacion_modo_frec_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_modo_frec_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtTipoLiquidacion_modo_frec_Initialized = value ;
   }

   public void setgxTv_SdtTipoLiquidacion_modo_frec_Initialized_SetNull( )
   {
      gxTv_SdtTipoLiquidacion_modo_frec_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtTipoLiquidacion_modo_frec_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra_Z( )
   {
      return gxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra_Z ;
   }

   public void setgxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra_Z( String value )
   {
      gxTv_SdtTipoLiquidacion_modo_frec_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_modo_frec_Modified = (short)(1) ;
      SetDirty("Tliqmodtra_Z");
      gxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra_Z = value ;
   }

   public void setgxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra_Z_SetNull( )
   {
      gxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra_Z = "" ;
      SetDirty("Tliqmodtra_Z");
   }

   public boolean getgxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag_Z( )
   {
      return gxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag_Z ;
   }

   public void setgxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag_Z( byte value )
   {
      gxTv_SdtTipoLiquidacion_modo_frec_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_modo_frec_Modified = (short)(1) ;
      SetDirty("Tliqfrecpag_Z");
      gxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag_Z = value ;
   }

   public void setgxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag_Z_SetNull( )
   {
      gxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag_Z = (byte)(0) ;
      SetDirty("Tliqfrecpag_Z");
   }

   public boolean getgxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec_Z( )
   {
      return gxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec_Z ;
   }

   public void setgxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec_Z( String value )
   {
      gxTv_SdtTipoLiquidacion_modo_frec_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_modo_frec_Modified = (short)(1) ;
      SetDirty("Tliqdescauxfrec_Z");
      gxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec_Z = value ;
   }

   public void setgxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec_Z_SetNull( )
   {
      gxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec_Z = "" ;
      SetDirty("Tliqdescauxfrec_Z");
   }

   public boolean getgxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra = "" ;
      gxTv_SdtTipoLiquidacion_modo_frec_N = (byte)(1) ;
      gxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec = "" ;
      gxTv_SdtTipoLiquidacion_modo_frec_Mode = "" ;
      gxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra_Z = "" ;
      gxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtTipoLiquidacion_modo_frec_N ;
   }

   public web.SdtTipoLiquidacion_modo_frec Clone( )
   {
      return (web.SdtTipoLiquidacion_modo_frec)(clone()) ;
   }

   public void setStruct( web.StructSdtTipoLiquidacion_modo_frec struct )
   {
      setgxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra(struct.getTliqmodtra());
      setgxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag(struct.getTliqfrecpag());
      setgxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec(struct.getTliqdescauxfrec());
      setgxTv_SdtTipoLiquidacion_modo_frec_Mode(struct.getMode());
      setgxTv_SdtTipoLiquidacion_modo_frec_Modified(struct.getModified());
      setgxTv_SdtTipoLiquidacion_modo_frec_Initialized(struct.getInitialized());
      setgxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra_Z(struct.getTliqmodtra_Z());
      setgxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag_Z(struct.getTliqfrecpag_Z());
      setgxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec_Z(struct.getTliqdescauxfrec_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtTipoLiquidacion_modo_frec getStruct( )
   {
      web.StructSdtTipoLiquidacion_modo_frec struct = new web.StructSdtTipoLiquidacion_modo_frec ();
      struct.setTliqmodtra(getgxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra());
      struct.setTliqfrecpag(getgxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag());
      struct.setTliqdescauxfrec(getgxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec());
      struct.setMode(getgxTv_SdtTipoLiquidacion_modo_frec_Mode());
      struct.setModified(getgxTv_SdtTipoLiquidacion_modo_frec_Modified());
      struct.setInitialized(getgxTv_SdtTipoLiquidacion_modo_frec_Initialized());
      struct.setTliqmodtra_Z(getgxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra_Z());
      struct.setTliqfrecpag_Z(getgxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag_Z());
      struct.setTliqdescauxfrec_Z(getgxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec_Z());
      return struct ;
   }

   private byte gxTv_SdtTipoLiquidacion_modo_frec_N ;
   private byte gxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag ;
   private byte gxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag_Z ;
   private short gxTv_SdtTipoLiquidacion_modo_frec_Modified ;
   private short gxTv_SdtTipoLiquidacion_modo_frec_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra ;
   private String gxTv_SdtTipoLiquidacion_modo_frec_Mode ;
   private String gxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec ;
   private String gxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec_Z ;
}

