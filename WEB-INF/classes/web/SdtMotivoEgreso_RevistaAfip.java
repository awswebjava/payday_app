package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtMotivoEgreso_RevistaAfip extends GxSilentTrnSdt
{
   public SdtMotivoEgreso_RevistaAfip( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtMotivoEgreso_RevistaAfip.class));
   }

   public SdtMotivoEgreso_RevistaAfip( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle, context, "SdtMotivoEgreso_RevistaAfip");
      initialize( remoteHandle) ;
   }

   public SdtMotivoEgreso_RevistaAfip( int remoteHandle ,
                                       StructSdtMotivoEgreso_RevistaAfip struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtMotivoEgreso_RevistaAfip( )
   {
      super( new ModelContext(SdtMotivoEgreso_RevistaAfip.class), "SdtMotivoEgreso_RevistaAfip");
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
      return (Object[][])(new Object[][]{new Object[]{"MegSitRevista", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "RevistaAfip");
      metadata.set("BT", "MotivoEgresoRevistaAfip");
      metadata.set("PK", "[ \"MegSitRevista\" ]");
      metadata.set("PKAssigned", "[ \"MegSitRevista\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\",\"MegCodigo\" ],\"FKMap\":[  ] },{ \"FK\":[ \"SitRevCodigo\" ],\"FKMap\":[ \"MegSitRevista-SitRevCodigo\" ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegSitRevista") )
            {
               gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegSitRevDescrip") )
            {
               gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegSitRevDef") )
            {
               gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegSitRelSec") )
            {
               gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegSitRelSecCli") )
            {
               gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegSitPadre") )
            {
               gxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegSitRelRef") )
            {
               gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegSitOld") )
            {
               gxTv_SdtMotivoEgreso_RevistaAfip_Megsitold = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtMotivoEgreso_RevistaAfip_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtMotivoEgreso_RevistaAfip_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtMotivoEgreso_RevistaAfip_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegSitRevista_Z") )
            {
               gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegSitRevDescrip_Z") )
            {
               gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegSitRevDef_Z") )
            {
               gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegSitRelSec_Z") )
            {
               gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegSitRelSecCli_Z") )
            {
               gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegSitPadre_Z") )
            {
               gxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegSitRelRef_Z") )
            {
               gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref_Z = oReader.getValue() ;
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
         sName = "MotivoEgreso.RevistaAfip" ;
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
      oWriter.writeElement("MegSitRevista", GXutil.trim( GXutil.str( gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MegSitRevDescrip", gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MegSitRevDef", GXutil.booltostr( gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MegSitRelSec", GXutil.trim( GXutil.str( gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MegSitRelSecCli", GXutil.trim( GXutil.str( gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MegSitPadre", GXutil.trim( GXutil.str( gxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MegSitRelRef", gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MegSitOld", gxTv_SdtMotivoEgreso_RevistaAfip_Megsitold);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtMotivoEgreso_RevistaAfip_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtMotivoEgreso_RevistaAfip_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtMotivoEgreso_RevistaAfip_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MegSitRevista_Z", GXutil.trim( GXutil.str( gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista_Z, 3, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MegSitRevDescrip_Z", gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MegSitRevDef_Z", GXutil.booltostr( gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MegSitRelSec_Z", GXutil.trim( GXutil.str( gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MegSitRelSecCli_Z", GXutil.trim( GXutil.str( gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MegSitPadre_Z", GXutil.trim( GXutil.str( gxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre_Z, 3, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MegSitRelRef_Z", gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref_Z);
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
      AddObjectProperty("MegSitRevista", gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista, false, includeNonInitialized);
      AddObjectProperty("MegSitRevDescrip", gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip, false, includeNonInitialized);
      AddObjectProperty("MegSitRevDef", gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef, false, includeNonInitialized);
      AddObjectProperty("MegSitRelSec", gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec, false, includeNonInitialized);
      AddObjectProperty("MegSitRelSecCli", gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli, false, includeNonInitialized);
      AddObjectProperty("MegSitPadre", gxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre, false, includeNonInitialized);
      AddObjectProperty("MegSitRelRef", gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref, false, includeNonInitialized);
      AddObjectProperty("MegSitOld", gxTv_SdtMotivoEgreso_RevistaAfip_Megsitold, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtMotivoEgreso_RevistaAfip_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtMotivoEgreso_RevistaAfip_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtMotivoEgreso_RevistaAfip_Initialized, false, includeNonInitialized);
         AddObjectProperty("MegSitRevista_Z", gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista_Z, false, includeNonInitialized);
         AddObjectProperty("MegSitRevDescrip_Z", gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip_Z, false, includeNonInitialized);
         AddObjectProperty("MegSitRevDef_Z", gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef_Z, false, includeNonInitialized);
         AddObjectProperty("MegSitRelSec_Z", gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec_Z, false, includeNonInitialized);
         AddObjectProperty("MegSitRelSecCli_Z", gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli_Z, false, includeNonInitialized);
         AddObjectProperty("MegSitPadre_Z", gxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre_Z, false, includeNonInitialized);
         AddObjectProperty("MegSitRelRef_Z", gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtMotivoEgreso_RevistaAfip sdt )
   {
      if ( sdt.IsDirty("MegSitRevista") )
      {
         gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(0) ;
         gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista = sdt.getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista() ;
      }
      if ( sdt.IsDirty("MegSitRevDescrip") )
      {
         gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(0) ;
         gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip = sdt.getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip() ;
      }
      if ( sdt.IsDirty("MegSitRevDef") )
      {
         gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(0) ;
         gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef = sdt.getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef() ;
      }
      if ( sdt.IsDirty("MegSitRelSec") )
      {
         gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(0) ;
         gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec = sdt.getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec() ;
      }
      if ( sdt.IsDirty("MegSitRelSecCli") )
      {
         gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(0) ;
         gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli = sdt.getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli() ;
      }
      if ( sdt.IsDirty("MegSitPadre") )
      {
         gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(0) ;
         gxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre = sdt.getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre() ;
      }
      if ( sdt.IsDirty("MegSitRelRef") )
      {
         gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(0) ;
         gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref = sdt.getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref() ;
      }
      if ( sdt.IsDirty("MegSitOld") )
      {
         gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(0) ;
         gxTv_SdtMotivoEgreso_RevistaAfip_Megsitold = sdt.getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitold() ;
      }
   }

   public short getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( )
   {
      return gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( short value )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_RevistaAfip_Modified = (short)(1) ;
      SetDirty("Megsitrevista");
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista = value ;
   }

   public String getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip( )
   {
      return gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip( String value )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_RevistaAfip_Modified = (short)(1) ;
      SetDirty("Megsitrevdescrip");
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip = value ;
   }

   public boolean getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef( )
   {
      return gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef( boolean value )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_RevistaAfip_Modified = (short)(1) ;
      SetDirty("Megsitrevdef");
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef = value ;
   }

   public int getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec( )
   {
      return gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec( int value )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_RevistaAfip_Modified = (short)(1) ;
      SetDirty("Megsitrelsec");
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec = value ;
   }

   public int getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli( )
   {
      return gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli( int value )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_RevistaAfip_Modified = (short)(1) ;
      SetDirty("Megsitrelseccli");
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli = value ;
   }

   public short getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre( )
   {
      return gxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre( short value )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_RevistaAfip_Modified = (short)(1) ;
      SetDirty("Megsitpadre");
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre = value ;
   }

   public String getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref( )
   {
      return gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref( String value )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_RevistaAfip_Modified = (short)(1) ;
      SetDirty("Megsitrelref");
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref = value ;
   }

   public String getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitold( )
   {
      return gxTv_SdtMotivoEgreso_RevistaAfip_Megsitold ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitold( String value )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_RevistaAfip_Modified = (short)(1) ;
      SetDirty("Megsitold");
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitold = value ;
   }

   public String getgxTv_SdtMotivoEgreso_RevistaAfip_Mode( )
   {
      return gxTv_SdtMotivoEgreso_RevistaAfip_Mode ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Mode( String value )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtMotivoEgreso_RevistaAfip_Mode = value ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Mode_SetNull( )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtMotivoEgreso_RevistaAfip_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtMotivoEgreso_RevistaAfip_Modified( )
   {
      return gxTv_SdtMotivoEgreso_RevistaAfip_Modified ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Modified( short value )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtMotivoEgreso_RevistaAfip_Modified = value ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Modified_SetNull( )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtMotivoEgreso_RevistaAfip_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtMotivoEgreso_RevistaAfip_Initialized( )
   {
      return gxTv_SdtMotivoEgreso_RevistaAfip_Initialized ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Initialized( short value )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_RevistaAfip_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtMotivoEgreso_RevistaAfip_Initialized = value ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Initialized_SetNull( )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtMotivoEgreso_RevistaAfip_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista_Z( )
   {
      return gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista_Z ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista_Z( short value )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_RevistaAfip_Modified = (short)(1) ;
      SetDirty("Megsitrevista_Z");
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista_Z = value ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista_Z_SetNull( )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista_Z = (short)(0) ;
      SetDirty("Megsitrevista_Z");
   }

   public boolean getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip_Z( )
   {
      return gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip_Z ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip_Z( String value )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_RevistaAfip_Modified = (short)(1) ;
      SetDirty("Megsitrevdescrip_Z");
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip_Z = value ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip_Z_SetNull( )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip_Z = "" ;
      SetDirty("Megsitrevdescrip_Z");
   }

   public boolean getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef_Z( )
   {
      return gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef_Z ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef_Z( boolean value )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_RevistaAfip_Modified = (short)(1) ;
      SetDirty("Megsitrevdef_Z");
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef_Z = value ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef_Z_SetNull( )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef_Z = false ;
      SetDirty("Megsitrevdef_Z");
   }

   public boolean getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec_Z( )
   {
      return gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec_Z ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec_Z( int value )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_RevistaAfip_Modified = (short)(1) ;
      SetDirty("Megsitrelsec_Z");
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec_Z = value ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec_Z_SetNull( )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec_Z = 0 ;
      SetDirty("Megsitrelsec_Z");
   }

   public boolean getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli_Z( )
   {
      return gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli_Z ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli_Z( int value )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_RevistaAfip_Modified = (short)(1) ;
      SetDirty("Megsitrelseccli_Z");
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli_Z = value ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli_Z_SetNull( )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli_Z = 0 ;
      SetDirty("Megsitrelseccli_Z");
   }

   public boolean getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre_Z( )
   {
      return gxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre_Z ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre_Z( short value )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_RevistaAfip_Modified = (short)(1) ;
      SetDirty("Megsitpadre_Z");
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre_Z = value ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre_Z_SetNull( )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre_Z = (short)(0) ;
      SetDirty("Megsitpadre_Z");
   }

   public boolean getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref_Z( )
   {
      return gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref_Z ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref_Z( String value )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_RevistaAfip_Modified = (short)(1) ;
      SetDirty("Megsitrelref_Z");
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref_Z = value ;
   }

   public void setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref_Z_SetNull( )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref_Z = "" ;
      SetDirty("Megsitrelref_Z");
   }

   public boolean getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtMotivoEgreso_RevistaAfip_N = (byte)(1) ;
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip = "" ;
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref = "" ;
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitold = "" ;
      gxTv_SdtMotivoEgreso_RevistaAfip_Mode = "" ;
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip_Z = "" ;
      gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtMotivoEgreso_RevistaAfip_N ;
   }

   public web.SdtMotivoEgreso_RevistaAfip Clone( )
   {
      return (web.SdtMotivoEgreso_RevistaAfip)(clone()) ;
   }

   public void setStruct( web.StructSdtMotivoEgreso_RevistaAfip struct )
   {
      setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista(struct.getMegsitrevista());
      setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip(struct.getMegsitrevdescrip());
      setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef(struct.getMegsitrevdef());
      setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec(struct.getMegsitrelsec());
      setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli(struct.getMegsitrelseccli());
      setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre(struct.getMegsitpadre());
      setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref(struct.getMegsitrelref());
      setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitold(struct.getMegsitold());
      setgxTv_SdtMotivoEgreso_RevistaAfip_Mode(struct.getMode());
      setgxTv_SdtMotivoEgreso_RevistaAfip_Modified(struct.getModified());
      setgxTv_SdtMotivoEgreso_RevistaAfip_Initialized(struct.getInitialized());
      setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista_Z(struct.getMegsitrevista_Z());
      setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip_Z(struct.getMegsitrevdescrip_Z());
      setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef_Z(struct.getMegsitrevdef_Z());
      setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec_Z(struct.getMegsitrelsec_Z());
      setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli_Z(struct.getMegsitrelseccli_Z());
      setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre_Z(struct.getMegsitpadre_Z());
      setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref_Z(struct.getMegsitrelref_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtMotivoEgreso_RevistaAfip getStruct( )
   {
      web.StructSdtMotivoEgreso_RevistaAfip struct = new web.StructSdtMotivoEgreso_RevistaAfip ();
      struct.setMegsitrevista(getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista());
      struct.setMegsitrevdescrip(getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip());
      struct.setMegsitrevdef(getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef());
      struct.setMegsitrelsec(getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec());
      struct.setMegsitrelseccli(getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli());
      struct.setMegsitpadre(getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre());
      struct.setMegsitrelref(getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref());
      struct.setMegsitold(getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitold());
      struct.setMode(getgxTv_SdtMotivoEgreso_RevistaAfip_Mode());
      struct.setModified(getgxTv_SdtMotivoEgreso_RevistaAfip_Modified());
      struct.setInitialized(getgxTv_SdtMotivoEgreso_RevistaAfip_Initialized());
      struct.setMegsitrevista_Z(getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista_Z());
      struct.setMegsitrevdescrip_Z(getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip_Z());
      struct.setMegsitrevdef_Z(getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef_Z());
      struct.setMegsitrelsec_Z(getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec_Z());
      struct.setMegsitrelseccli_Z(getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli_Z());
      struct.setMegsitpadre_Z(getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre_Z());
      struct.setMegsitrelref_Z(getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref_Z());
      return struct ;
   }

   private byte gxTv_SdtMotivoEgreso_RevistaAfip_N ;
   private short gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista ;
   private short gxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre ;
   private short gxTv_SdtMotivoEgreso_RevistaAfip_Modified ;
   private short gxTv_SdtMotivoEgreso_RevistaAfip_Initialized ;
   private short gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista_Z ;
   private short gxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec ;
   private int gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli ;
   private int gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec_Z ;
   private int gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli_Z ;
   private String gxTv_SdtMotivoEgreso_RevistaAfip_Mode ;
   private String sTagName ;
   private boolean gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef ;
   private boolean gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtMotivoEgreso_RevistaAfip_Megsitold ;
   private String gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip ;
   private String gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref ;
   private String gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip_Z ;
   private String gxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref_Z ;
}

