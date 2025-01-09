package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTCategorias_SDTCategoriasItem extends GxUserType
{
   public SdtSDTCategorias_SDTCategoriasItem( )
   {
      this(  new ModelContext(SdtSDTCategorias_SDTCategoriasItem.class));
   }

   public SdtSDTCategorias_SDTCategoriasItem( ModelContext context )
   {
      super( context, "SdtSDTCategorias_SDTCategoriasItem");
   }

   public SdtSDTCategorias_SDTCategoriasItem( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTCategorias_SDTCategoriasItem");
   }

   public SdtSDTCategorias_SDTCategoriasItem( StructSdtSDTCategorias_SDTCategoriasItem struct )
   {
      this();
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatCodigo") )
            {
               gxTv_SdtSDTCategorias_SDTCategoriasItem_Catcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatDescrip") )
            {
               gxTv_SdtSDTCategorias_SDTCategoriasItem_Catdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliPaiConve") )
            {
               gxTv_SdtSDTCategorias_SDTCategoriasItem_Clipaiconve = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConvenio") )
            {
               gxTv_SdtSDTCategorias_SDTCategoriasItem_Cliconvenio = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatClase") )
            {
               gxTv_SdtSDTCategorias_SDTCategoriasItem_Catclase = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatFrecAct") )
            {
               gxTv_SdtSDTCategorias_SDTCategoriasItem_Catfrecact = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatAfipCod") )
            {
               gxTv_SdtSDTCategorias_SDTCategoriasItem_Catafipcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatTipoTarifa") )
            {
               gxTv_SdtSDTCategorias_SDTCategoriasItem_Cattipotarifa = oReader.getValue() ;
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
         sName = "SDTCategorias.SDTCategoriasItem" ;
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
      oWriter.writeElement("CatCodigo", gxTv_SdtSDTCategorias_SDTCategoriasItem_Catcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatDescrip", gxTv_SdtSDTCategorias_SDTCategoriasItem_Catdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliPaiConve", GXutil.trim( GXutil.str( gxTv_SdtSDTCategorias_SDTCategoriasItem_Clipaiconve, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliConvenio", gxTv_SdtSDTCategorias_SDTCategoriasItem_Cliconvenio);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatClase", GXutil.trim( GXutil.str( gxTv_SdtSDTCategorias_SDTCategoriasItem_Catclase, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatFrecAct", GXutil.trim( GXutil.str( gxTv_SdtSDTCategorias_SDTCategoriasItem_Catfrecact, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatAfipCod", gxTv_SdtSDTCategorias_SDTCategoriasItem_Catafipcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatTipoTarifa", gxTv_SdtSDTCategorias_SDTCategoriasItem_Cattipotarifa);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
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
      AddObjectProperty("CatCodigo", gxTv_SdtSDTCategorias_SDTCategoriasItem_Catcodigo, false, false);
      AddObjectProperty("CatDescrip", gxTv_SdtSDTCategorias_SDTCategoriasItem_Catdescrip, false, false);
      AddObjectProperty("CliPaiConve", gxTv_SdtSDTCategorias_SDTCategoriasItem_Clipaiconve, false, false);
      AddObjectProperty("CliConvenio", gxTv_SdtSDTCategorias_SDTCategoriasItem_Cliconvenio, false, false);
      AddObjectProperty("CatClase", gxTv_SdtSDTCategorias_SDTCategoriasItem_Catclase, false, false);
      AddObjectProperty("CatFrecAct", gxTv_SdtSDTCategorias_SDTCategoriasItem_Catfrecact, false, false);
      AddObjectProperty("CatAfipCod", gxTv_SdtSDTCategorias_SDTCategoriasItem_Catafipcod, false, false);
      AddObjectProperty("CatTipoTarifa", gxTv_SdtSDTCategorias_SDTCategoriasItem_Cattipotarifa, false, false);
   }

   public String getgxTv_SdtSDTCategorias_SDTCategoriasItem_Catcodigo( )
   {
      return gxTv_SdtSDTCategorias_SDTCategoriasItem_Catcodigo ;
   }

   public void setgxTv_SdtSDTCategorias_SDTCategoriasItem_Catcodigo( String value )
   {
      gxTv_SdtSDTCategorias_SDTCategoriasItem_N = (byte)(0) ;
      gxTv_SdtSDTCategorias_SDTCategoriasItem_Catcodigo = value ;
   }

   public String getgxTv_SdtSDTCategorias_SDTCategoriasItem_Catdescrip( )
   {
      return gxTv_SdtSDTCategorias_SDTCategoriasItem_Catdescrip ;
   }

   public void setgxTv_SdtSDTCategorias_SDTCategoriasItem_Catdescrip( String value )
   {
      gxTv_SdtSDTCategorias_SDTCategoriasItem_N = (byte)(0) ;
      gxTv_SdtSDTCategorias_SDTCategoriasItem_Catdescrip = value ;
   }

   public short getgxTv_SdtSDTCategorias_SDTCategoriasItem_Clipaiconve( )
   {
      return gxTv_SdtSDTCategorias_SDTCategoriasItem_Clipaiconve ;
   }

   public void setgxTv_SdtSDTCategorias_SDTCategoriasItem_Clipaiconve( short value )
   {
      gxTv_SdtSDTCategorias_SDTCategoriasItem_N = (byte)(0) ;
      gxTv_SdtSDTCategorias_SDTCategoriasItem_Clipaiconve = value ;
   }

   public String getgxTv_SdtSDTCategorias_SDTCategoriasItem_Cliconvenio( )
   {
      return gxTv_SdtSDTCategorias_SDTCategoriasItem_Cliconvenio ;
   }

   public void setgxTv_SdtSDTCategorias_SDTCategoriasItem_Cliconvenio( String value )
   {
      gxTv_SdtSDTCategorias_SDTCategoriasItem_N = (byte)(0) ;
      gxTv_SdtSDTCategorias_SDTCategoriasItem_Cliconvenio = value ;
   }

   public byte getgxTv_SdtSDTCategorias_SDTCategoriasItem_Catclase( )
   {
      return gxTv_SdtSDTCategorias_SDTCategoriasItem_Catclase ;
   }

   public void setgxTv_SdtSDTCategorias_SDTCategoriasItem_Catclase( byte value )
   {
      gxTv_SdtSDTCategorias_SDTCategoriasItem_N = (byte)(0) ;
      gxTv_SdtSDTCategorias_SDTCategoriasItem_Catclase = value ;
   }

   public byte getgxTv_SdtSDTCategorias_SDTCategoriasItem_Catfrecact( )
   {
      return gxTv_SdtSDTCategorias_SDTCategoriasItem_Catfrecact ;
   }

   public void setgxTv_SdtSDTCategorias_SDTCategoriasItem_Catfrecact( byte value )
   {
      gxTv_SdtSDTCategorias_SDTCategoriasItem_N = (byte)(0) ;
      gxTv_SdtSDTCategorias_SDTCategoriasItem_Catfrecact = value ;
   }

   public String getgxTv_SdtSDTCategorias_SDTCategoriasItem_Catafipcod( )
   {
      return gxTv_SdtSDTCategorias_SDTCategoriasItem_Catafipcod ;
   }

   public void setgxTv_SdtSDTCategorias_SDTCategoriasItem_Catafipcod( String value )
   {
      gxTv_SdtSDTCategorias_SDTCategoriasItem_N = (byte)(0) ;
      gxTv_SdtSDTCategorias_SDTCategoriasItem_Catafipcod = value ;
   }

   public String getgxTv_SdtSDTCategorias_SDTCategoriasItem_Cattipotarifa( )
   {
      return gxTv_SdtSDTCategorias_SDTCategoriasItem_Cattipotarifa ;
   }

   public void setgxTv_SdtSDTCategorias_SDTCategoriasItem_Cattipotarifa( String value )
   {
      gxTv_SdtSDTCategorias_SDTCategoriasItem_N = (byte)(0) ;
      gxTv_SdtSDTCategorias_SDTCategoriasItem_Cattipotarifa = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTCategorias_SDTCategoriasItem_Catcodigo = "" ;
      gxTv_SdtSDTCategorias_SDTCategoriasItem_N = (byte)(1) ;
      gxTv_SdtSDTCategorias_SDTCategoriasItem_Catdescrip = "" ;
      gxTv_SdtSDTCategorias_SDTCategoriasItem_Cliconvenio = "" ;
      gxTv_SdtSDTCategorias_SDTCategoriasItem_Catafipcod = "" ;
      gxTv_SdtSDTCategorias_SDTCategoriasItem_Cattipotarifa = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTCategorias_SDTCategoriasItem_N ;
   }

   public web.SdtSDTCategorias_SDTCategoriasItem Clone( )
   {
      return (web.SdtSDTCategorias_SDTCategoriasItem)(clone()) ;
   }

   public void setStruct( web.StructSdtSDTCategorias_SDTCategoriasItem struct )
   {
      setgxTv_SdtSDTCategorias_SDTCategoriasItem_Catcodigo(struct.getCatcodigo());
      setgxTv_SdtSDTCategorias_SDTCategoriasItem_Catdescrip(struct.getCatdescrip());
      setgxTv_SdtSDTCategorias_SDTCategoriasItem_Clipaiconve(struct.getClipaiconve());
      setgxTv_SdtSDTCategorias_SDTCategoriasItem_Cliconvenio(struct.getCliconvenio());
      setgxTv_SdtSDTCategorias_SDTCategoriasItem_Catclase(struct.getCatclase());
      setgxTv_SdtSDTCategorias_SDTCategoriasItem_Catfrecact(struct.getCatfrecact());
      setgxTv_SdtSDTCategorias_SDTCategoriasItem_Catafipcod(struct.getCatafipcod());
      setgxTv_SdtSDTCategorias_SDTCategoriasItem_Cattipotarifa(struct.getCattipotarifa());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtSDTCategorias_SDTCategoriasItem getStruct( )
   {
      web.StructSdtSDTCategorias_SDTCategoriasItem struct = new web.StructSdtSDTCategorias_SDTCategoriasItem ();
      struct.setCatcodigo(getgxTv_SdtSDTCategorias_SDTCategoriasItem_Catcodigo());
      struct.setCatdescrip(getgxTv_SdtSDTCategorias_SDTCategoriasItem_Catdescrip());
      struct.setClipaiconve(getgxTv_SdtSDTCategorias_SDTCategoriasItem_Clipaiconve());
      struct.setCliconvenio(getgxTv_SdtSDTCategorias_SDTCategoriasItem_Cliconvenio());
      struct.setCatclase(getgxTv_SdtSDTCategorias_SDTCategoriasItem_Catclase());
      struct.setCatfrecact(getgxTv_SdtSDTCategorias_SDTCategoriasItem_Catfrecact());
      struct.setCatafipcod(getgxTv_SdtSDTCategorias_SDTCategoriasItem_Catafipcod());
      struct.setCattipotarifa(getgxTv_SdtSDTCategorias_SDTCategoriasItem_Cattipotarifa());
      return struct ;
   }

   protected byte gxTv_SdtSDTCategorias_SDTCategoriasItem_N ;
   protected byte gxTv_SdtSDTCategorias_SDTCategoriasItem_Catclase ;
   protected byte gxTv_SdtSDTCategorias_SDTCategoriasItem_Catfrecact ;
   protected short gxTv_SdtSDTCategorias_SDTCategoriasItem_Clipaiconve ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtSDTCategorias_SDTCategoriasItem_Catcodigo ;
   protected String gxTv_SdtSDTCategorias_SDTCategoriasItem_Cliconvenio ;
   protected String gxTv_SdtSDTCategorias_SDTCategoriasItem_Catafipcod ;
   protected String gxTv_SdtSDTCategorias_SDTCategoriasItem_Cattipotarifa ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTCategorias_SDTCategoriasItem_Catdescrip ;
}

