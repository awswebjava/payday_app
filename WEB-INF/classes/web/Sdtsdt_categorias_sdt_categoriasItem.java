package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_categorias_sdt_categoriasItem extends GxUserType
{
   public Sdtsdt_categorias_sdt_categoriasItem( )
   {
      this(  new ModelContext(Sdtsdt_categorias_sdt_categoriasItem.class));
   }

   public Sdtsdt_categorias_sdt_categoriasItem( ModelContext context )
   {
      super( context, "Sdtsdt_categorias_sdt_categoriasItem");
   }

   public Sdtsdt_categorias_sdt_categoriasItem( int remoteHandle ,
                                                ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_categorias_sdt_categoriasItem");
   }

   public Sdtsdt_categorias_sdt_categoriasItem( StructSdtsdt_categorias_sdt_categoriasItem struct )
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
               gxTv_Sdtsdt_categorias_sdt_categoriasItem_Catcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatDescrip") )
            {
               gxTv_Sdtsdt_categorias_sdt_categoriasItem_Catdescrip = oReader.getValue() ;
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
         sName = "sdt_categorias.sdt_categoriasItem" ;
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
      oWriter.writeElement("CatCodigo", gxTv_Sdtsdt_categorias_sdt_categoriasItem_Catcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatDescrip", gxTv_Sdtsdt_categorias_sdt_categoriasItem_Catdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
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
      AddObjectProperty("CatCodigo", gxTv_Sdtsdt_categorias_sdt_categoriasItem_Catcodigo, false, false);
      AddObjectProperty("CatDescrip", gxTv_Sdtsdt_categorias_sdt_categoriasItem_Catdescrip, false, false);
   }

   public String getgxTv_Sdtsdt_categorias_sdt_categoriasItem_Catcodigo( )
   {
      return gxTv_Sdtsdt_categorias_sdt_categoriasItem_Catcodigo ;
   }

   public void setgxTv_Sdtsdt_categorias_sdt_categoriasItem_Catcodigo( String value )
   {
      gxTv_Sdtsdt_categorias_sdt_categoriasItem_N = (byte)(0) ;
      gxTv_Sdtsdt_categorias_sdt_categoriasItem_Catcodigo = value ;
   }

   public String getgxTv_Sdtsdt_categorias_sdt_categoriasItem_Catdescrip( )
   {
      return gxTv_Sdtsdt_categorias_sdt_categoriasItem_Catdescrip ;
   }

   public void setgxTv_Sdtsdt_categorias_sdt_categoriasItem_Catdescrip( String value )
   {
      gxTv_Sdtsdt_categorias_sdt_categoriasItem_N = (byte)(0) ;
      gxTv_Sdtsdt_categorias_sdt_categoriasItem_Catdescrip = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_categorias_sdt_categoriasItem_Catcodigo = "" ;
      gxTv_Sdtsdt_categorias_sdt_categoriasItem_N = (byte)(1) ;
      gxTv_Sdtsdt_categorias_sdt_categoriasItem_Catdescrip = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_categorias_sdt_categoriasItem_N ;
   }

   public web.Sdtsdt_categorias_sdt_categoriasItem Clone( )
   {
      return (web.Sdtsdt_categorias_sdt_categoriasItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_categorias_sdt_categoriasItem struct )
   {
      setgxTv_Sdtsdt_categorias_sdt_categoriasItem_Catcodigo(struct.getCatcodigo());
      setgxTv_Sdtsdt_categorias_sdt_categoriasItem_Catdescrip(struct.getCatdescrip());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_categorias_sdt_categoriasItem getStruct( )
   {
      web.StructSdtsdt_categorias_sdt_categoriasItem struct = new web.StructSdtsdt_categorias_sdt_categoriasItem ();
      struct.setCatcodigo(getgxTv_Sdtsdt_categorias_sdt_categoriasItem_Catcodigo());
      struct.setCatdescrip(getgxTv_Sdtsdt_categorias_sdt_categoriasItem_Catdescrip());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_categorias_sdt_categoriasItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtsdt_categorias_sdt_categoriasItem_Catcodigo ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_categorias_sdt_categoriasItem_Catdescrip ;
}

